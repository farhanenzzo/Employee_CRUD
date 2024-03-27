package com.farhan.crud.Service;

import com.farhan.crud.Model.Employee;
import com.farhan.crud.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl {
    @Autowired
    private EmployeeRepository employeeRepository;


    public void saveEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    public List<Employee> fetchAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long employeeId) {
        return employeeRepository.findById(employeeId).orElse(null);
    }

    public boolean updateEmployeeById(Long employeeId, Employee employee){
        Optional<Employee> existingEmployee = employeeRepository.findById(employeeId);
        if(existingEmployee.isPresent()) {
            Employee updateEmployee = existingEmployee.get();

            updateEmployee.setEmployeeName(employee.getEmployeeName());
            updateEmployee.setEmployeeSalary(employee.getEmployeeSalary());
            updateEmployee.setEmail(employee.getEmail());

            employeeRepository.save(updateEmployee);
            return  true;
        }
        return false;
    }

    public boolean deleteEmployeeById(Long employeeId) {
        try {
            employeeRepository.deleteById(employeeId);
            return true;
        } catch (Exception msg) {
            return false;
        }
    }
}
