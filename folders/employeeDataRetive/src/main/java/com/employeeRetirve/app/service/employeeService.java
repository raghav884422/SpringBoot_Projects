package com.employeeRetirve.app.service;


import java.util.List;


import org.springframework.stereotype.Service;

import com.employeeRetirve.app.entities.employee;
import com.employeeRetirve.app.repositry.employeeRepostry;

@Service
public class employeeService {
	employeeRepostry EmployeeRepo;

	public employeeService(employeeRepostry employeeRepo) {
		super();
		EmployeeRepo = employeeRepo;
	}
	public List<employee> getAllEmloyee(){
		return EmployeeRepo.findAll();
	}
	public employee getemployee(int id) {
//	Optional<employee>	op = EmployeeRepo.findById(id);
//	if(op!=null) {
//		employee e=op.get();
//		return e;
//	}
//	else {
//		return null;
//	}
		return EmployeeRepo.findById(id).orElse(null);
	}

}
