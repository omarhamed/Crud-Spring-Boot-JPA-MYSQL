package com.omatar.cruddemo;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.omatar.cruddemo.dao.StudentDao;
import com.omatar.cruddemo.entity.Student;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDao studentDao) {
		return runner -> {
			// create new student
			 createStudent(studentDao);
			// retrieve student by id
			// findById(studentDao);
			// retrieve all students
			// findAll(studentDao);
			// updateStudent(studentDao);
			// deleteStudent(studentDao);
			// findAll(studentDao);
		};
	}

	private void findAll(StudentDao studentDao) {
		List<Student> studentsList = studentDao.findAll();
		for (Student student : studentsList) {
			System.out.println("Student : " + student.toString());
		}
	}

	private void findById(StudentDao studentDao) {
		System.out.println("Create Student Object ....");
		Student student = studentDao.findById(1);
		System.out.println("Retrevid student with id : 1 " + student.toString());

	}

	private void createStudent(StudentDao studentDao) {
		System.out.println("Create Student Object ....");
		Student student = new Student("Omar", "Matar", "oh83521@gmail.com");

		System.out.println("Save Student ....");
		studentDao.save(student);

		System.out.println("Created student with id : " + student.getId());

	}

	private void updateStudent(StudentDao studentDao) {
		int studentId = 1;
		System.out.println("Try to find id : " + studentId);

		Student student = studentDao.findById(studentId);
		System.out.println("Try to find student with id 1 : " + student);

		System.out.println("Update Student ....");

		student.setFirstName("Ahmed");
		studentDao.update(student);

		System.out.println("Updated student : " + student);
	}

	private void deleteStudent(StudentDao studentDao) {
		int studentId = 1;

		System.out.println("Delete Student ....");

		studentDao.delete(studentId);
	}

}
