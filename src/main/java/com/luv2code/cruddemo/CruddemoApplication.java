package com.luv2code.cruddemo;

import com.luv2code.cruddemo.dao.StudentDAO;
import com.luv2code.cruddemo.entity.Student;
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
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){

		return runner -> {
			//createStudent(studentDAO);
			//createMultipleStudent(studentDAO);
			//readStudent(studentDAO);
			queryForStudents(studentDAO);
			//queryForStudentsByLastName(studentDAO);
			//updateStudent(studentDAO);
			//deleteStudent(studentDAO);
			//deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students ...");
		int numRowsDeleted = studentDAO.deleteAll();
		System.out.println("Deleted row count: "+numRowsDeleted);

	}

	private void deleteStudent(StudentDAO studentDAO) {

		// get a list of students
		int studentId=3;
		System.out.println("Deleting student ID is: "+studentId);
		studentDAO.delete(studentId);

	}

	private void updateStudent(StudentDAO studentDAO) {

		//retrieve student based onthe id : PK
		int studentId = 1;
		System.out.println("Getting student with id: "+studentId);
		Student myStudent = studentDAO.findById(studentId);
		// change firstName to "Janem"
		System.out.println("Update student ...");
		myStudent.setFirstName("Janem");

		//update the student
        studentDAO.update(myStudent);
		// display the student
		System.out.println("Updated student : "+myStudent);


	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Jim");
		//display the list
		for (Student tempStudent:theStudents) {
			System.out.println(tempStudent);

		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		//get list of students
		List<Student> theStudents = studentDAO.findAll();

		// display
		for (Student tempStudent:theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		//create a student obj
		System.out.println("Creating new student object ...");
		Student tempStudent=new Student("Jim", "Jam", "jim@jan.gmail.com");

		//save the student
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		//display id of saved student
		int theID=tempStudent.getId();

		//retrieve the student based on the id: PK
		System.out.println("Retrieving the student with id ..."+ theID);
		Student mystudent = studentDAO.findById(theID);

		//display the student
		System.out.println("Found the student: "+mystudent);

	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create the students
		System.out.println("Creating new students ...");
		Student tempStudent1=new Student("A.Ali", "Jan", "ali@jan.gmail.com");
		Student tempStudent2=new Student("A.Veli", "Jack", "veli@jan.gmail.com");
		Student tempStudent3=new Student("A.Mali", "Jim", "mali@jan.gmail.com");
		Student tempStudent4=new Student("A.Alim", "Janjem", "alim@jan.gmail.com");
		Student tempStudent5=new Student("A.Velim", "Jackjan", "velim@jan.gmail.com");
		//save the students obj
		System.out.println("Saving the students ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
		studentDAO.save(tempStudent4);
		studentDAO.save(tempStudent5);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create the student obj
		System.out.println("Creating new student object ...");
		Student tempStudent=new Student("Ali", "Jan", "ali@jan.gmail.com");

		//save the student obj
		System.out.println("Saving the student ...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		System.out.println("Saved student. Generated id: "+tempStudent.getId());
	}

}
