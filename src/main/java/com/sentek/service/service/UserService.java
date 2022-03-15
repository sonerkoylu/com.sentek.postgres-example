package com.sentek.service.service;

import com.sentek.service.entity.User;

public interface UserService {
    User findByUserNameAndPassword(String username, String password);
}
