package com.cookieGenration.app.entiity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Kodnestuser {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private int age;
	
	@Column
	private int marks;
	
	@Enumerated(EnumType.STRING)
	private Role role;

	public Kodnestuser() {
		// TODO Auto-generated constructor stub
	}

	public Kodnestuser(String username, String password, int age, int marks, Role role) {
		super();
		this.username = username;
		this.password = password;
		this.age = age;
		this.marks = marks;
		this.role = role;
	}

	public Kodnestuser(int id, String username, String password, int age, int marks, Role role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.age = age;
		this.marks = marks;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, id, marks, password, role, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Kodnestuser other = (Kodnestuser) obj;
		return age == other.age && id == other.id && marks == other.marks && Objects.equals(password, other.password)
				&& role == other.role && Objects.equals(username, other.username);
	}

	@Override
	public String toString() {
		return "Kodnestuser [id=" + id + ", username=" + username + ", password=" + password + ", age=" + age
				+ ", marks=" + marks + ", role=" + role + "]";
	}

}
