package com.mertspring.cruddemo.dao;

import com.mertspring.cruddemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    // this is enough
}
