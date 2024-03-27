package com.farhan.crud.Controller;

import com.farhan.crud.Model.Employee;
import com.farhan.crud.Service.EmployeeService;
import com.farhan.crud.Service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/emp")
public class EmployeeController {
    @Autowired
    private EmployeeServiceImpl employeeService;

    @PostMapping
    public String createEmployee(@RequestBody Employee employee) {
        employeeService.saveEmployee(employee);
        return "New employee has been created";
    }

    @GetMapping
    public List<Employee> employeeList() {
        return employeeService.fetchAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee findEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        boolean deleted = employeeService.deleteEmployeeById(id);
        if(deleted) {
            return "User has been deleted";
        } else {
            return "User not available";
        }
    }

    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        boolean updated = employeeService.updateEmployeeById(id, employee);

        if(updated) {
            return "User has been updated";
        } else {
            return "User not available";
        }
    }
}
