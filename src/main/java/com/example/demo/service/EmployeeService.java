package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Customer;
import com.example.demo.entity.Employee;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Employee getById(Integer id);
    Employee save(Employee employee);
    Employee update(Employee employee);
    void delete(Integer id);
}
