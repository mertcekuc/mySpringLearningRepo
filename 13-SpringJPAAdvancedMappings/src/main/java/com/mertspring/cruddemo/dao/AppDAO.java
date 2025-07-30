package com.mertspring.cruddemo.dao;

import com.mertspring.cruddemo.entity.Course;
import com.mertspring.cruddemo.entity.Instructor;
import com.mertspring.cruddemo.entity.InstructorDetail;

import java.util.List;


public interface AppDAO {

     void save(Instructor instructor);
     Instructor findByID(int id);
     void deleteNyID(int id);
     InstructorDetail findInstructorDetail(int id);
     void deleteInstructionDetailByID(int id);
     List<Course> findCoursesByInstructorID(int id);
     Instructor findInstructorByIdJoinFetch(int id);
     void update(Instructor instructor);
}
