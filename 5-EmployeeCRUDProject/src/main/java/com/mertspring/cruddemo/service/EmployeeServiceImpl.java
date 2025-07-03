package com.mertspring.cruddemo.service;

import com.mertspring.cruddemo.dao.EmployeeDAO;
import com.mertspring.cruddemo.dao.EmployeeDAOJpaImpl;
import com.mertspring.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO dao){
        this.employeeDAO = dao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee finByID(int id) {
        return employeeDAO.findByID(id);
    }
    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }
    @Transactional
    @Override
    public void delete(int id) {
        employeeDAO.deleteByID(id);
    }
}
