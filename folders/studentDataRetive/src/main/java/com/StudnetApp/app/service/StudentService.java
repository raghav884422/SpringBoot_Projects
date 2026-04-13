package com.StudnetApp.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.StudnetApp.app.entity.Student;
import com.StudnetApp.app.repo.StudentRepo;

@Service
public class StudentService {
	StudentRepo sr;
	
public StudentService(StudentRepo sr) {
		super();
		this.sr = sr;
	}

public List<Student> getAllStudent(){
	return sr.findAll();
}
}
