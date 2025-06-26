package com.mertspring.springjpa;

import com.mertspring.springjpa.Entity.Student;
import com.mertspring.springjpa.dao.StudentDAO;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class SpringjpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringjpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner-> {
			//createStudent(studentDAO);

			//createMultipleStudent(studentDAO);

			//readStudent(studentDAO);

			//readAllStudents(studentDAO);

			queryByLastName(studentDAO);
		};
	}

	private void queryByLastName(StudentDAO studentDAO) {
		List<Student> listofq = studentDAO.findByLastName("Doe");

		for (Student s: listofq)
			System.out.println(s);

	}

	private void readAllStudents(StudentDAO studentDAO) {
		List<Student> listofstidemts = studentDAO.findAll();
		System.out.println("Students:");
		for (Student s: listofstidemts){
			System.out.println(s);
		}
	}

	private void readStudent(StudentDAO studentDAO) {

		Student foundStudent = studentDAO.findByID(2);
		System.out.println("Student found");
		System.out.println(foundStudent);
	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		System.out.println("Creating 3 new student objects");
		Student tempStudent1 = new Student("John", "Doe", "jdoe@mef");
		Student tempStudent2 = new Student("Marry", "Pubic", "mp@mef");
		Student tempStudent3 = new Student("first", "last", "f@mef");

		System.out.println("Saving students");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		System.out.println("Creating new student object");
		Student tempStudent = new Student("Mert", "Cekuc", "cekucmert@mef");
		studentDAO.save(tempStudent);

		System.out.println("Student SAVED!");
		System.out.println(tempStudent);
	}

}
