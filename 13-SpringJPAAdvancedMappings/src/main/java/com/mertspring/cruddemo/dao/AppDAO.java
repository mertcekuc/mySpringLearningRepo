package com.mertspring.cruddemo.dao;

import com.mertspring.cruddemo.entity.Instructor;


public interface AppDAO {

    public void save(Instructor instructor);
    public Instructor findByID(int id);
    public void deleteNyID(int id);
}
