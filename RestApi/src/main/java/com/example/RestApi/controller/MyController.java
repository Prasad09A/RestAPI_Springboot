package com.example.RestApi.controller;

import com.example.RestApi.entity.User;
import com.example.RestApi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MyController {

    @Autowired
    private UserService userService;

    @PostMapping("/user")
    public User addUserDetails(@RequestBody User user){
        return userService.createUser(user);
    }

    @GetMapping("/user")
    public List<User> getUserDetails(){
        return userService.getAllUsers();
    }

    @GetMapping("/user/{id}")
    public User getUserDetail(@PathVariable int id){
        return userService.getUser(id);
    }

    @PutMapping("/user/{id}")
    public User updateUser(@PathVariable int id, @RequestBody User user){
        return userService.updateUser(id, user);
    }

    @PatchMapping("/user/{id}")
    public User partialUpdate(@PathVariable int id, @RequestBody User user){
        return userService.patchUser(id, user);
    }

    @DeleteMapping("/user/{id}")
    public String deleteUserById(@PathVariable int id){
         userService.deleteUser(id);
        return "User deleted successfully";
    }
}
