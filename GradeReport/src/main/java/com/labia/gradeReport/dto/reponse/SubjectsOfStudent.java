package com.labia.gradeReport.dto.reponse;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SubjectsOfStudent {
    private Integer curriculumId;
    private String curriculumCode;
    private String curriculumName;
    private Integer termId;
    private Integer termNo;
    private String subjectCode;
    private String subjectName;
    private Integer credits;
}
