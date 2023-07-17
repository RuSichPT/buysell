package com.github.rusichpt.buysell.controllers;

import com.github.rusichpt.buysell.models.User;
import com.github.rusichpt.buysell.services.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/registration")
    String registration(User user) {
//        userService.createUser(user);

        return "registration";
    }
}
