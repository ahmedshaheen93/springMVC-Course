package com.shaheen.service;

import com.shaheen.model.User;

public interface UserService {
    User getByEmailAndPassword(String email, String password);

    User save(User user);
}
