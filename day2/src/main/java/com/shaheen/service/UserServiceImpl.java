package com.shaheen.service;

import com.shaheen.model.User;

public class UserServiceImpl implements UserService {
    public User getByEmailAndPassword(String email, String password) {
        return null;
    }

    public User save(User user) {
        System.out.println(user);
        return user;
    }
}
