/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.labia.gradeReport.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author nhhuy05
 */
@Controller
public class LectureController {

    @GetMapping("/lecturePage")
    public String getLecturePage() {
        return "lecture_page";
    }

    @GetMapping("/studentGradePage")
    public String getStudentGradePage() {
        return "student_grade_page";
    }

    @GetMapping("/importStudentGradePage")
    public String getImportStudentGradePage() {
        return "import_student_grade_page";
    }
    
    @GetMapping("/importGradeDetailPage")
    public String getImportGradeDetailPage() {
        return "import_grade_detail_page";
    }

}
