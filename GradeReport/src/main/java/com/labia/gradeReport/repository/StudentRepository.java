package com.labia.gradeReport.repository;

import com.labia.gradeReport.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {
    @Query(value = "SELECT s FROM Student s WHERE s.userId = ?1")
    public Optional<Student> findByUserId(Integer userId);
}
