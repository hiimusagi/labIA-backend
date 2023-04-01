package com.labia.gradeReport.controllers;

import com.labia.gradeReport.models.Student;
import com.labia.gradeReport.models.Users;
import com.labia.gradeReport.services.AssessmentsServices;
import com.labia.gradeReport.services.StudentServices;
import com.labia.gradeReport.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/assessment")
public class AssessmentsController {
    private final AssessmentsServices assessmentsServices;
    private final StudentServices studentServices;
    private final UserService userService;

    @GetMapping("/student")
    public String AssessmentsOfStudentAndSubject(@RequestParam("subjectCode") String subjectId, Model model, Authentication authentication){
        Users users = userService.getAuthenticatedUser(authentication);
        Student student = studentServices.getStudentByUserId(users.getUserId());
        model.addAttribute("studentId", student.getStudentId());
        model.addAttribute("subjectCode", subjectId);
        model.addAttribute("Assessments", assessmentsServices.getAssessmentsOfStudentAndSubject(student.getStudentId(), subjectId));
        return "mark_view";
    }
}
