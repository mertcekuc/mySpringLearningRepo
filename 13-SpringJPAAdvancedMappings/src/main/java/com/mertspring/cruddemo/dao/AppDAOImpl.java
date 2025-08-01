package com.mertspring.cruddemo.dao;

import com.mertspring.cruddemo.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findByID(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);
        return instructor;
    }

    @Override
    @Transactional
    public void deleteNyID(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);
        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetail(int id) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, id);
        return instructorDetail;
    }

    @Override
    @Transactional
    public void deleteInstructionDetailByID(int id) {
        InstructorDetail detail = entityManager.find(InstructorDetail.class,id);
        detail.getInstructor().setInstructorDetail(null);
        entityManager.remove(detail);
    }

    @Override
    public List<Course> findCoursesByInstructorID(int id) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id= :data"
                ,Course.class);
        query.setParameter("data",id);

        List<Course> result = query.getResultList();

        return result;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {
        TypedQuery<Instructor> query = entityManager.createQuery(
                "select i from Instructor i " +
                        "JOIN FETCH i.courses " +
                        "JOIN FETCH i.instructorDetail " +
                        "WHERE i.id = :data",Instructor.class);

        query.setParameter("data",id);

        Instructor instructor = query.getSingleResult();

        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseByID(int id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorByID(int id) {
        Instructor instructor = entityManager.find(Instructor.class,id);
        for (Course course: instructor.getCourses()
             ) {
            course.setInstructor(null);
        }
        entityManager.remove(instructor);
    }

    @Override
    @Transactional
    public void deleteCourseByID(int id) {
        Course course = entityManager.find(Course.class,id);
        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);
    }

    @Override
    public Course findCourseAndReviews(int id) {
        TypedQuery<Course> query = entityManager.createQuery(
                "select c from Course c " +
                        "JOIN FETCH c.reviews " +
                        "WHERE c.id=:data",Course.class
        );

        query.setParameter("data",id);

        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public Course findCourseAndStudentsByCourseID(int id) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c " +
                "JOIN FETCH c.students " +
                "Where c.id = :data",Course.class);
        query.setParameter("data",id);
        Course course = query.getSingleResult();

        return course;
    }

    @Override
    public Student findStudentAndCoursesByStudentID(int id) {
        TypedQuery<Student> query = entityManager.createQuery("select s from Student s " +
                "JOIN FETCH s.courses " +
                "where s.id = :data", Student.class);

        query.setParameter("data",id);
        Student student = query.getSingleResult();
        return student;
    }

    @Override
    @Transactional
    public void update(Student student) {
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudentByID(int id) {
        Student student = entityManager.find(Student.class,id);

        if(student != null){
            List<Course> courses = student.getCourses();
            for(Course course:courses){
                course.getStudents().remove(student);
            }
        }

        entityManager.remove(student);
    }
}
