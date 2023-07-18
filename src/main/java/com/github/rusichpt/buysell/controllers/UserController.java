package com.github.rusichpt.buysell.controllers;

import com.github.rusichpt.buysell.models.User;
import com.github.rusichpt.buysell.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/login")
    public String login(User user) {
        return "login";
    }

    @GetMapping("/registration")
    public String registration(User user) {
        return "registration";
    }

    @PostMapping("/registration")
    public String createUser(User user, Model model) {
        if (!userService.createUser(user)) {
            String s = String.format("Пользователь с таким email:%s уже существует", user.getEmail());
            model.addAttribute("errorMessage", s);
            return "registration";
        }

        return "redirect:/login";
    }

    @GetMapping("/hello")
    public String securityUrl() {
        return "hello";
    }
}
