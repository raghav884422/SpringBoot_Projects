package com.Student.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Student.app.entity.Student;
import com.Student.app.repository.StudentRepo;

@Service
public class StudentService {
	StudentRepo studentrepo;

	public StudentService(StudentRepo studentrepo) {
		super();
		this.studentrepo = studentrepo;
	}


	public List<Student> getAllStudent() {
		return studentrepo.findAll();
	}

	public Student getById(String name) {
		return studentrepo.findById(name).orElse(null);
	}
	public Student creatStudent(Student stu) {
		return studentrepo.save(stu);
	}
	public String delete(String name) {
		studentrepo.deleteById(name);
		return "student deleted succesfully";
	}
	public Student update(Student stu) {
		Student s = studentrepo.findById(stu.getName()).orElse(null);
		
		if(s==null) {
			return null;
		}
		
		s.setId(stu.getId());
		s.setName(stu.getName());
		s.setAge(stu.getAge());
		s.setMarks(stu.getMarks());
		return studentrepo.save(s);
	}
	

}
