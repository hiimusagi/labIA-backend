package com.labia.gradeReport.repository;

import com.labia.gradeReport.models.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Integer> {
    @Override
    Optional<Subject> findById(Integer integer);
}
