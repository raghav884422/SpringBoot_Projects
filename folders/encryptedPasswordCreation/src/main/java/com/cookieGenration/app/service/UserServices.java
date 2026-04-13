package com.cookieGenration.app.service;

import com.cookieGenration.app.entiity.Kodnestuser;

public interface UserServices {
public Kodnestuser register(Kodnestuser kodnestuser);
public boolean login(String username, String password);
}
