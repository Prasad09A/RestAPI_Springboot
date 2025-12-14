package com.example.RestApi.controller;

import com.example.RestApi.entity.User;
import com.example.RestApi.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    private UserService userService;

    @PostMapping("/user")
    public User addUserDetails(@RequestBody User user){
        return userService.createUser(user);
    }
}
