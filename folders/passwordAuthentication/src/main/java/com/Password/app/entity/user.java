package com.Password.app.entity;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class user {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int userid;
	@Column
	String password;
	@Column
	String role;
	@Column
	String email;
	@Column
	String phone;
	@Column
	String username;
	public user() {
		// TODO Auto-generated constructor stub
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public user(int userid, String password, String role, String email, String phone, String username) {
		super();
		this.userid = userid;
		this.password = password;
		this.role = role;
		this.email = email;
		this.phone = phone;
		this.username = username;
	}
	@Override
	public int hashCode() {
		return Objects.hash(email, password, phone, role, userid, username);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		user other = (user) obj;
		return Objects.equals(email, other.email) && Objects.equals(password, other.password)
				&& Objects.equals(phone, other.phone) && Objects.equals(role, other.role) && userid == other.userid
				&& Objects.equals(username, other.username);
	}
	@Override
	public String toString() {
		return "user [userid=" + userid + ", password=" + password + ", role=" + role + ", email=" + email + ", phone="
				+ phone + ", username=" + username + "]";
	}
	
}
