package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.dto.UserDto;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    void createUser(UserDto user);

    void updateUser(UserDto user);

    UserDto findById(Long id);

    UserDto findByEmail(String email);

    void removeUserById(Long id);

    List<UserDto> getAllUsers();
}
