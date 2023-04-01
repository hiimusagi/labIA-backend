package com.labia.gradeReport.controllers;

import com.labia.gradeReport.models.Student;
import com.labia.gradeReport.models.Users;
import com.labia.gradeReport.services.StudentServices;
import com.labia.gradeReport.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
@RequestMapping("/student")
public class StudentController {
    private final StudentServices studentServices;
    private final UserService userService;

    @GetMapping(value = "/subjects")
    public String studentSubjects(Model model, Authentication authentication){
        Users users = userService.getAuthenticatedUser(authentication);
        Student student = studentServices.getStudentByUserId(users.getUserId());
        model.addAttribute("studentId", student.getStudentId());
        model.addAttribute("studentSubjects", studentServices.subjectsOfStudents(student.getCurriculumId()));
        return "student_subject_list";
    }
}
