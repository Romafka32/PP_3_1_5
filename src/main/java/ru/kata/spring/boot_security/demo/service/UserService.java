package ru.kata.spring.boot_security.demo.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService extends UserDetailsService {
    void createUser(User user);

    void updateUser(User user);

    User findById(Long id);

    User findByEmail(String email);

    void removeUserById(Long id);

    List<User> getAllUsers();
}
