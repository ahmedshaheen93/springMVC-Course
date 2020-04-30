package com.shaheen.service;

import com.shaheen.model.User;
import com.shaheen.repository.UserRepository;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    
    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user) {
        userRepository.save(user);
        return user;
    }

    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
