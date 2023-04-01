/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.labia.gradeReport.repository;

import com.labia.gradeReport.models.Lecture;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nhhuy05
 */
@Repository
public interface LectureRepository extends JpaRepository<Lecture, String>{
    @Query(value = "SELECT l FROM Lecture l WHERE l.userId = ?1")
    public Optional<Lecture> findByUserId(Integer userId);
    
    
}
