package ru.kata.spring.boot_security.demo.controllers;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.kata.spring.boot_security.demo.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Set;

import static ru.kata.spring.boot_security.demo.model.RoleType.ROLE_ADMIN;
import static ru.kata.spring.boot_security.demo.model.RoleType.ROLE_USER;

@Controller
@RequestMapping("/")
public class HelloController {
    @GetMapping
    public String redirect() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        User user = (User) authentication.getPrincipal();

        if (roles.contains(ROLE_ADMIN.name())) {
            return "redirect:/admin";
        } else if (roles.contains(ROLE_USER.name())) {
            System.out.println(user.getRoles());
            return "redirect:/user";
        }
        return "redirect:/user";
    }
}
