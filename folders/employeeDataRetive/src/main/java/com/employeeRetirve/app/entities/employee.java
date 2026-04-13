package com.employeeRetirve.app.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table
public class employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@Column
	String name;
	@Column
	String gender;
	@Column
	int salary;
	
	
	public employee(int id, String name, String gender, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.salary = salary;
	}
	
	public employee() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "employee [id=" + id + ", name=" + name + ", gender=" + gender + ", salary=" + salary + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(gender, id, name, salary);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		employee other = (employee) obj;
		return Objects.equals(gender, other.gender) && id == other.id && Objects.equals(name, other.name)
				&& salary == other.salary;
	}
	

}
