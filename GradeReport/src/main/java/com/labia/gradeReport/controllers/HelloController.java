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

    //    Get == method.get
    @GetMapping("/hello")
    public String sayHello(Authentication authentication, Model model) {
        Users users = userService.getAuthenticatedUser(authentication);
        model.addAttribute("users", users);
        return "hello";
    }

    @GetMapping("/login")
    public String getLecturePage() {
        return "login";
    }
    @PostMapping("/login")
    public String handleLogin(@RequestParam String username, @RequestParam String password) {
        /*TODO
        -2 conditions using sql query.
            +If login like student, redirect to student something
            +If login like lecture, redirect to lecture something
         */
        return "lecture_page";
    }
}