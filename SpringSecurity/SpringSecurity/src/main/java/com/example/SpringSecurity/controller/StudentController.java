package com.example.SpringSecurity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringSecurity.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {
	List<Student> students=new ArrayList<>(List.of(new Student(1,"gopi","java"),new Student(2,"karthik","spring")));
	
	@GetMapping("students")
	public List<Student> getStudents(){
		return students;
	}
	@PostMapping("/student")
	public void addStudent(@RequestBody Student stu) {
		students.add(stu);
	}
  @GetMapping("csrf-token")
  public CsrfToken getCsrf(HttpServletRequest req) {
	  return (CsrfToken)req.getAttribute("_csrf");
  }
}
