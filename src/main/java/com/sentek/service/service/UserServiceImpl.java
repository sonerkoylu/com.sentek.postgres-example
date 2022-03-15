package com.sentek.service.service;

import com.sentek.service.dto.UserDto;
import com.sentek.service.entity.User;
import com.sentek.service.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto findByUserNameAndPassword(String username, String password) {
        User user = userRepository.findByUsernameAndPassword(username, password);

        return modelMapper.map(user, UserDto.class);
    }

    @Override
    public List<UserDto> getAllByUsernameNotNull() {
        List<User> users = userRepository.getAllByUsernameNotNull();

        return users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
    }

    @Override
    public UserDto save(UserDto userDto) {
        User user = modelMapper.map(userDto, User.class);
        user.setPassword("123456");
        return modelMapper.map(userRepository.save(user), UserDto.class);
    }
}
