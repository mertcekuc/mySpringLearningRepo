package com.mertspring.cruddemo.dao;

import com.mertspring.cruddemo.entity.Employee;
import java.util.List;
public interface EmployeeDAO {

    List<Employee> findAll();
    Employee findByID(int id);
    Employee save(Employee theEmployee);
    void deleteByID(int id);
}
