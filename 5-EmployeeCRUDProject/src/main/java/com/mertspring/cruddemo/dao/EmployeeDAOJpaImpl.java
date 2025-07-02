package com.mertspring.cruddemo.dao;

import com.mertspring.cruddemo.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJpaImpl implements EmployeeDAO {
    private EntityManager entityManager;

    @Autowired
    EmployeeDAOJpaImpl(EntityManager theEntityManager){
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        List<Employee> result = entityManager
                .createQuery("from Employee", Employee.class)
                .getResultList();
        return result;
    }
}
