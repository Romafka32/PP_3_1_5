package ru.kata.spring.boot_security.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

@Getter
@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum RoleType {
    ROLE_ADMIN("ADMIN"),
    ROLE_USER("USER");

    private final String role;

    RoleType(String role) {
        this.role = role;
    }
}
