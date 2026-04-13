package com.employeeRetirve.app.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.employeeRetirve.app.entities.employee;
@Repository
public interface employeeRepostry extends JpaRepository<employee, Integer> {

}
