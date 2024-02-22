package com.employee_management.service;

import com.employee_management.model.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAllEmployee(); // get all employee
    void save(Employee employee); // save an info
    Employee getById(Long id); // get by id

    void deleteById(Long id); // delect by id
}
