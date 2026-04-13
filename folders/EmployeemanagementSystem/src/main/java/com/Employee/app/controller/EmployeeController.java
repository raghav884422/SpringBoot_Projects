package com.Employee.app.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Employee.app.entity.Employee;
import com.Employee.app.service.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController {
	EmployeeService es;

	public EmployeeController(EmployeeService es) {
		super();
		this.es = es;
	}

	@PostMapping
	public Employee CreateEmployee(Employee employee) {
		return es.creatEmployee(employee);
	}

	@GetMapping
	public List<Employee> getAllEmployee() {
		return es.getAllEmployee();
	}
	@GetMapping("/{id}")
	public Employee getById(@PathVariable int id ) {
		return es.getEmployeeById(id);
	}
	@DeleteMapping("/{id}")
	public String deleteById(@PathVariable int id) {
		es.deleteemloyeeById(id);
		return "Employee deleted succesfully";
	}
	@PutMapping("/{emp}")
	
	public Employee update(@PathVariable("emp"
			+ "+ ") int  id,@RequestBody Employee emp) {
		return es.updateEmployeeById(id, emp);
		
	}
}
