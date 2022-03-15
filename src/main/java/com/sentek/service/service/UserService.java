package com.sentek.service.service;

import com.sentek.service.dto.UserDto;
import com.sentek.service.entity.User;

import java.util.List;

public interface UserService {
    UserDto findByUserNameAndPassword(String username, String password);

    List<UserDto> getAllByUsernameNotNull();
    UserDto save(UserDto userDto);
}
