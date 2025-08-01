package com.mertspring.cruddemo;

import com.mertspring.cruddemo.dao.AppDAO;
import com.mertspring.cruddemo.entity.Course;
import com.mertspring.cruddemo.entity.Instructor;
import com.mertspring.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
			return runner -> {
					//createInstructor(appDAO);
					//findInstructor(appDAO);
					//deleteInstructor(appDAO);
					//findInstructorDetail(appDAO);
					//deleteInstructorDetail(appDAO);
					//createInstructorWithCourses(appDAO);
					//findInstructorWithCourses(appDAO);
					//findCoursesByInstructor(appDAO);
					//findInstructorWithCourseByFetch(appDAO);
					//updateInstructor(appDAO);
					//updateCourse(appDAO);
					//deleteInstructorUpdated(appDAO);
					deleteCouse(appDAO);
				};
			}

	private void deleteCouse(AppDAO appDAO) {
		int id = 10;
		System.out.println(String.format("Course %d will be deleted",id));
		appDAO.deleteCourseByID(id);
		System.out.println("DONE");
	}

	private void deleteInstructorUpdated(AppDAO appDAO) {
		int id=1;
		appDAO.deleteInstructorByID(id);
		System.out.println("DONE");
	}

	private void updateCourse(AppDAO appDAO) {
		Course course = appDAO.findCourseByID(10);
		course.setTitle("Updated course");
		System.out.println("Updating: "+course);
		appDAO.update(course);
		System.out.println("DONE");

	}

	private void updateInstructor(AppDAO appDAO) {
		Instructor instructor = appDAO.findByID(1);
		System.out.println("Before Update");
		System.out.println(instructor);

		instructor.getInstructorDetail().setYoutubeChannel("youtube.com/testAccount");
		System.out.println("After update");
		System.out.println(instructor);
		appDAO.update(instructor);
		System.out.println("DONE");

	}

	private void findInstructorWithCourseByFetch(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(id);
		System.out.println("FOUND");
		System.out.println(instructor);
		System.out.println(instructor.getCourses());
		System.out.println("DONE");
	}

	private void findCoursesByInstructor(AppDAO appDAO) {
		int id = 1;
		Instructor instructor = appDAO.findByID(id);

		List<Course> result = appDAO.findCoursesByInstructorID(id);

		instructor.setCourses(result);
		System.out.println(instructor);
		System.out.println(instructor.getCourses());

		System.out.println("DONE");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id=1;
		System.out.println("finding instructor "+id);

		Instructor instructor = appDAO.findByID(id);

		System.out.println("the instructor: " +instructor);

		System.out.println("Courses:"+instructor.getCourses());

		System.out.println("Done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor = new Instructor("Mert","Cekuc","mc@test.com");

		InstructorDetail instructorDetail = new InstructorDetail(
				"yt.com/mc",
				"Computer Science"
		);

		instructor.setInstructorDetail(instructorDetail);

		Course c1 = new Course("Java");
		Course c2 = new Course("Python");
		Course c3 = new Course("JavaScript");

		instructor.addCourse(c1);
		instructor.addCourse(c2);
		instructor.addCourse(c3);


		appDAO.save(instructor);
		System.out.println("Done");

	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		System.out.println("Deleteing instructor 2");
		System.out.println(appDAO.findByID(3));
		appDAO.deleteInstructionDetailByID(3);
		System.out.println("Done");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		InstructorDetail instructorDetail = appDAO.findInstructorDetail(1);

		System.out.println(instructorDetail);
		System.out.println(instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		System.out.println("instructor 2 wull be deleted");
		findInstructor(appDAO);
		appDAO.deleteNyID(2);

	}

	private void findInstructor(AppDAO appDAO) {
		Instructor instructor= appDAO.findByID(2);

		System.out.println(instructor);
	}

	private void createInstructor(AppDAO appDAO) {
		Instructor instructor = new Instructor("John","Doe","jd@test.com");

		InstructorDetail instructorDetail = new InstructorDetail(
				"yt.com/jd",
				"coding"
		);

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: "+instructor);
		appDAO.save(instructor);

	}
}

