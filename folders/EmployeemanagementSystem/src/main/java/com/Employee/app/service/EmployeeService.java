package com.Employee.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Employee.app.entity.Employee;
import com.Employee.app.repostry.EmployeeRepo;
@Service
public class EmployeeService {
	EmployeeRepo er;

	public EmployeeService(EmployeeRepo er) {
		super();
		this.er = er;
	}

	public Employee creatEmployee(Employee emp) {
		return er.save(emp);
	}

	public List<Employee> getAllEmployee() {
		return er.findAll();
	}

	public Employee getEmployeeById(int id) {
		return er.findById(id).orElse(null);
	}
	public void deleteemloyeeById(int id) {
		er.deleteById(id);
	}
	public Employee updateEmployeeById(int id,Employee newData) {
		Employee e = er.findById(id).orElse(null);
		if(e==null) {
			return null;
		}
		e.setName(newData.getName());
		e.setPassword(newData.getPassword());
		e.setSalary(newData.getSalary());
		e.setGender(newData.getGender());
		e.setAge(newData.getAge());
		return er.save(e);
	}
}
