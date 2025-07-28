package com.mertspring.cruddemo.dao;

import com.mertspring.cruddemo.entity.Instructor;
import com.mertspring.cruddemo.entity.InstructorDetail;


public interface AppDAO {

     void save(Instructor instructor);
     Instructor findByID(int id);
     void deleteNyID(int id);
     InstructorDetail findInstructorDetail(int id);
}
