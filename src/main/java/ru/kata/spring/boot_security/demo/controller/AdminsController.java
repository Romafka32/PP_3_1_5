package ru.kata.spring.boot_security.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.dto.UserDto;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminsController {

    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getAllUsers() {
        List<UserDto> list= userService.getAllUsers();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userService.findById(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<HttpStatus> addUser(@RequestBody UserDto userDto) {
        userService.createUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/users/{id}")
    public ResponseEntity<HttpStatus> updateUser(@RequestBody UserDto userDto) {
        userService.updateUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(value = "/users/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }
}
