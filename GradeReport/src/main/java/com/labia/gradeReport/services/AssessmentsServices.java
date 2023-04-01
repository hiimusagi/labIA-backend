package com.labia.gradeReport.services;

import com.labia.gradeReport.models.Assessments;
import com.labia.gradeReport.repository.AssessmentsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AssessmentsServices {

    private final AssessmentsRepository assessmentsRepository;

    public List<Assessments> getAssessmentsOfStudentAndSubject(String studentId, String subjectId) {
        return assessmentsRepository.findBySubjectAndStudent(studentId, subjectId);
    }

    public Optional<Assessments> getAssessmentsOfStudentAndSubjectAndType(String studentId, String subjectId, String assessmentType) {
        return assessmentsRepository.findBySubjectAndStudentAndType(studentId, subjectId, assessmentType);
    }

    public void saveGrade(String studentId, String subjectCode, String asssessmentType, Integer asssessmentGrade) {

        Optional<Assessments> assessments = getAssessmentsOfStudentAndSubjectAndType(studentId, subjectCode, asssessmentType);
        if (assessments.isPresent()) {
            assessments.get().setAssessmentGrade(asssessmentGrade);
            assessmentsRepository.save(assessments.get());
        }
    }
}
