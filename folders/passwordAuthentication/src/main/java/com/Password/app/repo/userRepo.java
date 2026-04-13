package com.Password.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Password.app.entity.user;
import java.util.List;


public interface userRepo extends JpaRepository<user, Integer>{
   user findByUsername(String username);
}
