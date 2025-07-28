package com.mertspring.cruddemo;

import com.mertspring.cruddemo.dao.AppDAO;
import com.mertspring.cruddemo.entity.Instructor;
import com.mertspring.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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
					deleteInstructorDetail(appDAO);
				};
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

