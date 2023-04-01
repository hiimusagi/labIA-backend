package com.labia.gradeReport.services;

import com.labia.gradeReport.models.Assessments;
import com.labia.gradeReport.repository.AssessmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AssessmentsServices {
    private final AssessmentsRepository assessmentsRepository;

    public List<Assessments> getAssessmentsOfStudentAndSubject(String studentId , String subjectId){
        return assessmentsRepository.findBySubjectAndStudent(studentId, subjectId);
    }
}
