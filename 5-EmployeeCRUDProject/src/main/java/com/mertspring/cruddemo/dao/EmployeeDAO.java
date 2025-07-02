package com.mertspring.cruddemo.dao;

import com.mertspring.cruddemo.entity.Employee;
import java.util.List;
public interface EmployeeDAO {
    List<Employee> findAll();
}
