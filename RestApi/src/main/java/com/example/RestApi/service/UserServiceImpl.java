package com.example.RestApi.service;

import com.example.RestApi.entity.User;
import com.example.RestApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
    return (User) userRepository.save(user);
    }
}
