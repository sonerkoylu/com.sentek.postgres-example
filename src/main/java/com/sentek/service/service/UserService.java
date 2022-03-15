package com.sentek.service.service;

import com.sentek.service.entity.User;

import java.util.List;

public interface UserService {
    User findByUserNameAndPassword(String username, String password);

    List<User> getAllByUsernameNotNull();
}
