package com.example.RestApi.service;

import com.example.RestApi.entity.User;
import com.example.RestApi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {
    return (User) userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll(Sort.by("id"));
    }

    @Override
    public User getUser(int id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));
    }

    @Override
    public User updateUser(int id, User user) {
        User existingUser= userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));

        existingUser.setName(user.getName());
        existingUser.setEmail(user.getEmail());
        existingUser.setCity(user.getCity());

        return userRepository.save(existingUser);
    }

    @Override
    public User patchUser(int id, User user) {
        User existingUser=userRepository.findById(id).orElseThrow(()->new RuntimeException("User not found"));

        if(user.getName()!=null){
            existingUser.setName(user.getName());
        }
        if(user.getEmail()!=null){
            existingUser.setEmail(user.getEmail());
        }
        if(user.getCity()!=null){
            existingUser.setCity(user.getCity());
        }

        return userRepository.save(existingUser);
    }

    @Override
    public void deleteUser(int id) {
         userRepository.deleteById(id);
    }


}
