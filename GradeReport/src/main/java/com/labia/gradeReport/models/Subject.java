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
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subject_code")
    private String subjectCode;

    @Column(name = "term_id")
    private Integer termId;

    @Column(name = "subject_name")
    private String subjectName;

    @Column(name = "credits")
    private Integer credits;
}
