package com.mertspring.springjpa.dao;

import com.mertspring.springjpa.Entity.Student;

import java.util.List;

public interface StudentDAO {

    void save(Student student);
    Student findByID(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
    void update(Student student);
    void delete(Integer id);
    int deleteAll();

}
