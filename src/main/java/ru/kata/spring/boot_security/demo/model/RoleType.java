package ru.kata.spring.boot_security.demo.model;

import lombok.Getter;

@Getter
public enum RoleType {
//    ROLE_ADMIN,
//    ROLE_USER;

    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER");

    private final String role;

    RoleType(String role) {
        this.role = role;
    }

}
