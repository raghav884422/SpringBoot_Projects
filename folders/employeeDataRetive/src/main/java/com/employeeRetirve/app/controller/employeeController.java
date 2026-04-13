package com.employeeRetirve.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeeRetirve.app.entities.employee;
import com.employeeRetirve.app.service.employeeService;

@RestController
@RequestMapping("/api")
public class employeeController {
employeeService es;

public employeeController(employeeService es) {
	super();
	this.es = es;
}

@GetMapping("/employee")
public List<employee> getAllEmloyee(){
	return es.getAllEmloyee();
}

@GetMapping("/employee/{uid}")
public employee getEmployeeById(@PathVariable("uid") int id) {
	return es.getemployee(id);
	
}
}
