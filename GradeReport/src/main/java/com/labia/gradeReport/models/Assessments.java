package com.labia.gradeReport.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name = "assessments")
@NoArgsConstructor
@AllArgsConstructor
public class Assessments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assessment_id")
    private Integer assessmentId;

    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "student_id")
    private String studentId;

    @Column(name = "assessment_type")
    private String assessmentType;

    @Column(name = "assessment_grade")
    private Integer assessmentGrade;
}
