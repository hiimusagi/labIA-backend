package com.labia.gradeReport.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    //    Get == method.get
    @GetMapping("/hello")
    public String sayHello() {
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