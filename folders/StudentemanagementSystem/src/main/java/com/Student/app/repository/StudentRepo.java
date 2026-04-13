package com.Student.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Student.app.entity.Student;

public interface StudentRepo extends JpaRepository<Student, String> {


}
