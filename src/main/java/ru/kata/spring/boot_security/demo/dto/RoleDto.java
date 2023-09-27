package ru.kata.spring.boot_security.demo.dto;


import lombok.Data;
import ru.kata.spring.boot_security.demo.model.RoleType;

@Data
public class RoleDto {

    private Long id;
    private RoleType name;
}
