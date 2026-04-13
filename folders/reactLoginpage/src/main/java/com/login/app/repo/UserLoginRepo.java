package com.login.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.app.entity.Userlogin;
import java.util.List;

public interface UserLoginRepo extends JpaRepository<Userlogin, Integer> {

    Userlogin findByUsername(String username);

}

