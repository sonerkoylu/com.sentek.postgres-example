package com.sentek.service.controller;

import com.sentek.service.entity.User;
import com.sentek.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public User login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return userService.findByUserNameAndPassword(username,password);
    }

    @GetMapping
    public List<User> getUsersByUsernameNotNull(){
        return userService.getAllByUsernameNotNull();
    }
}
