package com.example.springJDBC;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.example.springJDBC.Model.Student;
import com.example.springJDBC.service.StudentService;

@SpringBootApplication
public class SpringJdbcApplication {

	public static void main(String[] args) {

		ApplicationContext  context=SpringApplication.run(SpringJdbcApplication.class, args);
		Student s=context.getBean(Student.class);
		s.setRollno(504);
		s.setName("gopi");
		s.setMarks(60);
		
		StudentService service=context.getBean(StudentService.class);
		service.addStudent(s);
		

		List<Student> students=service.getStudents();
		for(Student stu:students)
		System.out.println(stu);

	}

}
