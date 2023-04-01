/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.labia.gradeReport.controllers;

import com.labia.gradeReport.models.Lecture;
import com.labia.gradeReport.models.Users;
import com.labia.gradeReport.services.LectureServices;
import com.labia.gradeReport.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author nhhuy05
 */
@Controller
@RequiredArgsConstructor
public class LectureController {
    
    private final LectureServices lectureServices;
    private final UserService userService;

    @GetMapping("/lecturePage")
    public String getLecturePage() {
        return "lecture_page";
    }

    @GetMapping("/studentGradePage")
    public String getStudentGradePage() {
        return "student_grade_page";
    }

    @GetMapping("/importStudentGradePage")
    public String getImportStudentGradePage(Model model, Authentication authentication) {
        Users users = userService.getAuthenticatedUser(authentication);
        Lecture lecture = lectureServices.getLectureByUserId(users.getUserId());
        model.addAttribute("lectureName", lecture.getLectureName());
        model.addAttribute("subjectsOfLectureList", lectureServices.subjectsOfLecture(lecture.getLectureId()));
        return "import_student_grade_page";
    }
    
    @GetMapping("/importGradeDetailPage")
    public String getImportGradeDetailPage(Model model, Authentication authentication, @RequestParam("subjectCode") String subjectCode) {
        model.addAttribute("subjectCode", subjectCode);
        model.addAttribute("studentsOfSubjectTermPT1List", lectureServices.studentsOfSubjectTerm(subjectCode,"PT1"));
        model.addAttribute("studentsOfSubjectTermPT2List", lectureServices.studentsOfSubjectTerm(subjectCode,"PT2"));
        model.addAttribute("studentsOfSubjectTermFEList", lectureServices.studentsOfSubjectTerm(subjectCode,"FE"));
        return "import_grade_detail_page";
    }

}
