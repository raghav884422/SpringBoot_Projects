package com.salesavvy.app.service;

import com.salesavvy.app.entiry.User;

public interface userServiceContract {

    User registerUser(User user);

    // ✅ ADD THIS
    User login(String username, String password);
}
