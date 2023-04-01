package com.labia.gradeReport.repository;

import com.labia.gradeReport.models.Assessments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssessmentsRepository extends JpaRepository<Assessments, Integer> {

    @Query(value = "SELECT a from Assessments a WHERE a.studentId = ?1 AND a.subjectCode = ?2")
    public List<Assessments> findBySubjectAndStudent(String studentId, String subjectCode);
    
    @Query(value = "SELECT a from Assessments a WHERE a.studentId = ?1 AND a.subjectCode = ?2 AND a.assessmentType = ?3")
    public Optional<Assessments> findBySubjectAndStudentAndType(String studentId, String subjectCode,String assessmentType);
}
