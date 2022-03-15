package com.sentek.service.controller;

import com.sentek.service.dto.UserDto;
import com.sentek.service.entity.User;
import com.sentek.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public UserDto login(@RequestParam("username") String username, @RequestParam("password") String password) {
        return userService.findByUserNameAndPassword(username,password);
    }

    @GetMapping
    public List<UserDto> getUsersByUsernameNotNull(){
        return userService.getAllByUsernameNotNull();
    }

    @PostMapping("/create")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.save(userDto);
    }
}
