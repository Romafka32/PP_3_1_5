package ru.kata.spring.boot_security.demo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import ru.kata.spring.boot_security.demo.dto.RoleDto;
import ru.kata.spring.boot_security.demo.dto.UserDto;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

@Mapper(unmappedTargetPolicy = ReportingPolicy.WARN,
        componentModel = "spring")
public interface UserMapper {

    UserDto toDto(User user);

    User toEntity(UserDto user);

    Role toEntity(RoleDto user);

    RoleDto toEntity(Role user);
}
