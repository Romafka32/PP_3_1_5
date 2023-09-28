package ru.kata.spring.boot_security.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.kata.spring.boot_security.demo.dto.UserDto;
import ru.kata.spring.boot_security.demo.mapper.UserMapper;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    public final UserRepository userRepository;
    public final RoleRepository roleRepository;
    public final PasswordEncoder passwordEncoder;
    public final UserMapper userMapper;

    @Override
    public void createUser(UserDto user) {
        if (userRepository.findByUsername(userMapper.toEntity(user).getUsername()).isEmpty()) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(userMapper.toEntity(user));
        }
    }

    @Override
    public void updateUser(UserDto user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(
                userMapper.toEntity(user));
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto findById(Long id) {
        return userMapper.toDto(
                userRepository.findById(id)
                        .orElse(new User()));
    }

    @Override
    @Transactional(readOnly = true)
    public UserDto findByUsername(String username) {
        return userMapper.toDto(
                userRepository.findByUsername(username)
                        .orElse(new User()));

    }

    @Override
    public void removeUserById(Long id) {
        if (userRepository.findById(id).isPresent()) {
            userRepository.deleteById(id);
        }
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userMapper::toDto).collect(Collectors.toList());
    }
}
