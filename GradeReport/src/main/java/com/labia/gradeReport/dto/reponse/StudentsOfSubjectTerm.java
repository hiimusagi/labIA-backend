/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.labia.gradeReport.dto.reponse;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author nhhuy05
 */
@Getter
@Setter
public class StudentsOfSubjectTerm {
    
    private String studentName;
    private String studentId;
    private Integer curriculumId;
    private String curriculumCode;
    private String subjectCode;
    private Integer termId;
    private String assessmentType;
    private Integer assessmentGrade;
}
