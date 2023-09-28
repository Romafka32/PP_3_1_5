package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.dto.UserDto;
import java.util.List;

public interface UserService {

    void createUser(UserDto user);

    void updateUser(UserDto user);

    UserDto findById(Long id);

    UserDto findByUsername(String username);

    void removeUserById(Long id);

    List<UserDto> getAllUsers();
}
