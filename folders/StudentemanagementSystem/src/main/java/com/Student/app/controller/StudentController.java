package com.Student.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Student.app.entity.Student;
import com.Student.app.service.StudentService;

@RestController
@RequestMapping("/api")
public class StudentController {
StudentService ss;

public StudentController(StudentService ss) {
	super();
	this.ss = ss;
}
@GetMapping("/all")
public List<Student> getAll(){
	return ss.getAllStudent();
}
@PostMapping("/")

public Student create(@RequestBody Student stu) {
	return ss.creatStudent(stu);
}
@PostMapping("/delete")
public void deleteByid(@RequestBody Student stu) {
	ss.delete(stu.getName());
}
@GetMapping("/student/{name}")
public Student getById(@PathVariable Student stu) {
	return ss.getById(stu.getName());
}
@GetMapping("/update")
public Student updateStudent(@RequestBody Student stu) {
	return ss.update(stu);
}
}
