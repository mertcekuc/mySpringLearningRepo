package com.mertspring.cruddemo.service;

import com.mertspring.cruddemo.dao.EmployeeRepository;
import com.mertspring.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository dao){
        this.employeeRepository = dao;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee finByID(int id) {
        Optional<Employee> result = employeeRepository.findById(id);

        Employee theEmp;
        if(result.isPresent()){
            theEmp = result.get();
        }

        else
            throw  new RuntimeException("Employee cant foudn with id:" +id);

        return theEmp;
    }

    @Transactional
    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }
    @Transactional
    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }
}
