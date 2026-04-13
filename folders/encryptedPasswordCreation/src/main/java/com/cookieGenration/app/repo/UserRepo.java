package com.cookieGenration.app.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cookieGenration.app.controller.userController;
import com.cookieGenration.app.entiity.Kodnestuser;
import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<Kodnestuser, Integer>{
public Kodnestuser findByUsername(String username);

}
