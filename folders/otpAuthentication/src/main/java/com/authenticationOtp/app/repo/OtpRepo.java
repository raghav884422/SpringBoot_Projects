package com.authenticationOtp.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.authenticationOtp.app.entity.Otp;
import java.util.List;


public interface  OtpRepo extends JpaRepository<Otp	, Integer> {
public Otp  findByOtpvalue(int otpvalue);
}
