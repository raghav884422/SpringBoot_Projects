package com.authenticationOtp.app.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Otp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int otpid;
	@Column
	int otpvalue;
	@Column
	LocalDateTime createat;
	@OneToOne
	@JoinColumn(name = "uid")
	Users user;

	public Otp(int otpid, int otpvalue, LocalDateTime createat, Users user) {
		super();
		this.otpid = otpid;
		this.otpvalue = otpvalue;
		this.createat = createat;
		this.user = user;
	}

	public Otp() {
		// TODO Auto-generated constructor stub
	}

	public Otp(int otpvalue, LocalDateTime createat) {
		super();
		this.otpvalue = otpvalue;
		this.createat = createat;
	}

	public int getOtpid() {
		return otpid;
	}

	public void setOtpid(int otpid) {
		this.otpid = otpid;
	}

	public int getOtpvalue() {
		return otpvalue;
	}

	public void setOtpvalue(int otpvalue) {
		this.otpvalue = otpvalue;
	}

	public LocalDateTime getCreateat() {
		return createat;
	}

	public void setCreateat(LocalDateTime createat) {
		this.createat = createat;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	@Override
	public int hashCode() {
		return Objects.hash(createat, otpid, otpvalue, user);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Otp other = (Otp) obj;
		return Objects.equals(createat, other.createat) && otpid == other.otpid && otpvalue == other.otpvalue
				&& Objects.equals(user, other.user);
	}

	@Override
	public String toString() {
		return "otp [otpid=" + otpid + ", otpvalue=" + otpvalue + ", createat=" + createat + ", user=" + user + "]";
	}

	public Otp(int otpvalue, LocalDateTime createat, Users user) {
		super();
		this.otpvalue = otpvalue;
		this.createat = createat;
		this.user = user;
	}

}
