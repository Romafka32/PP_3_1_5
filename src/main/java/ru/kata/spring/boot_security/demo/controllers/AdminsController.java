package ru.kata.spring.boot_security.demo.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.repository.RoleRepository;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class AdminsController {

    private final UserService userService;
    private final RoleRepository roleRepository;

    @GetMapping
    public String getAllUsers(ModelMap model) {
        model.addAttribute("users", userService.getAllUsers());

        return "users";
    }

    @GetMapping("/{id}")
    public String getOneUser(@PathVariable("id") Long id, ModelMap model) {
        model.addAttribute("user", userService.findById(id));
        return "details";
    }

    @GetMapping("/new")
    public String newUser(@ModelAttribute("user") User user, ModelMap model) {
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("allRoles", roles);
        return "new";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable("id") Long id, ModelMap model) {
        List<Role> roles = roleRepository.findAll();
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("allRoles", roles);
        return "edit";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("user") User user) {
        userService.createUser(user);
        return "redirect:/";
    }

    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") Long id) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.removeUserById(id);
        return "redirect:/";
    }
}
