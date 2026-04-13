package com.salesavvy.app.userrepositries;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesavvy.app.entiry.User;

import java.util.Optional;
@Repository
public interface UserReopsitory extends JpaRepository<User, Integer> {
	Optional<User> findByEmail(String email);

	Optional<User> findByUsername(String username);
}
