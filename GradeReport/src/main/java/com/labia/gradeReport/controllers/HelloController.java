package com.labia.gradeReport.controllers;

import com.labia.gradeReport.models.Users;
import com.labia.gradeReport.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequiredArgsConstructor
public class HelloController {
    private final UserService userService;

    @GetMapping("/hello")
    public String sayHello(Authentication authentication, Model model) {
        Users users = userService.getAuthenticatedUser(authentication);
        model.addAttribute("users", users);
        return "hello";
    }

    @GetMapping("/")
    public String getLoginPage() {
        return "login";
    }
}
