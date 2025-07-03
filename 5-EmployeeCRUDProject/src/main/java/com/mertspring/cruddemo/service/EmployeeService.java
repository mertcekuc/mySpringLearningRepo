package com.mertspring.cruddemo.service;

import com.mertspring.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();
    Employee finByID(int id);
    Employee save(Employee employee);
    void delete(int id);
}
