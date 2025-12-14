package com.example.RestApi.service;

import com.example.RestApi.entity.User;
import jakarta.persistence.OrderBy;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User createUser(User user);

    public List<User> getAllUsers();

    public User getUser(int id);

    public User updateUser(int id, User user);

    public User patchUser(int id, User user);

    public void deleteUser(int id);

}
