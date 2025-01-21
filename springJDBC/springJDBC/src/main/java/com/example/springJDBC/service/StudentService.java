package com.example.springJDBC.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springJDBC.Model.Student;
import com.example.springJDBC.Repository.StudentRepository;
@Service
public class StudentService {
	@Autowired
    StudentRepository repo;
	public void addStudent(Student s) {
    repo.save(s);
		
		
	}
	public List<Student> getStudents(){
		return repo.findAll();
	}

}
