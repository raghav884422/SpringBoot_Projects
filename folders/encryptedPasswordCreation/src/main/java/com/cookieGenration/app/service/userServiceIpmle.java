package com.cookieGenration.app.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.cookieGenration.app.entiity.Kodnestuser;
import com.cookieGenration.app.repo.UserRepo;

@Service
public class userServiceIpmle implements UserServices {

   

    private UserRepo repo;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public userServiceIpmle(UserRepo repo) {
        this.repo = repo;
        this.bCryptPasswordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public Kodnestuser register(Kodnestuser kodnestuser) {

        // get plain password
        String password = kodnestuser.getPassword();

        // encrypt password
        String encodedPass = bCryptPasswordEncoder.encode(password);

        // store encrypted password
        kodnestuser.setPassword(encodedPass);

        return repo.save(kodnestuser);
    }
    public boolean login(String username, String password) {
    Kodnestuser user= repo.findByUsername(username);
    if(user!=null && bCryptPasswordEncoder.matches(password, user.getPassword())) {
    return true;
    }
    return false;
    }
}
