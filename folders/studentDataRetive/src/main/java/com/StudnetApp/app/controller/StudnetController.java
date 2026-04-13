package com.StudnetApp.app.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.StudnetApp.app.entity.Student;
import com.StudnetApp.app.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudnetController {
	StudentService ss;
	
	public StudnetController(StudentService ss) {
		super();
		this.ss = ss;
	}
@GetMapping("/student")
	public List<Student> getAllStudent(){
		return ss.getAllStudent();
	}
}
