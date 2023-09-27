package ru.kata.spring.boot_security.demo.dto;

import lombok.Data;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.Set;


@Data
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Byte age;
    private String password;
    private Set<Role> roles;

    public String getUsername() {
        return getEmail();
    }
}

