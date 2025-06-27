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

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//readAllStudents(studentDAO);

			//queryByLastName(studentDAO);

			//updateStuednt(studentDAO);

			//deleteStuednt(studentDAO);

			//removeAllStudents(studentDAO);


		};
	}

	private void removeAllStudents(StudentDAO studentDAO) {
		int count = studentDAO.deleteAll();
		System.out.printf("All %d students are removed!",count);
	}

	private void deleteStuednt(StudentDAO studentDAO) {
		int id =3;
		System.out.println("Studnet " + id +"will be deleted");
		studentDAO.delete(3);
		System.out.println(":....");
		System.out.println("deleted");
	}

	private void updateStuednt(StudentDAO studentDAO) {

		//change name of student
		Student temp = studentDAO.findByID(1);
		temp.setFirstName("Mert");
		temp.setLastName("Cekuc");
		studentDAO.update(temp);
		System.out.println("Stuednt updated");
		System.out.println(temp);
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
