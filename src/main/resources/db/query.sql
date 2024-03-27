CREATE TABLE employee (
    employee_id BIGINT PRIMARY KEY AUTO_INCREMENT,
    employee_name VARCHAR(255),
    employee_salary FLOAT
);


ALTER TABLE employee
ADD COLUMN email VARCHAR(255) NOT NULL UNIQUE;

INSERT INTO employee (employee_name, employee_salary, email)
VALUES ('John Doe', 50000.00, 'john@example.com');
