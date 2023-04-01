/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.labia.gradeReport.models;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author nhhuy05
 */
@Entity
@Table(name = "lecture")
@Getter
@Setter
public class Lecture {
    
    @Id
    @Column(name = "lecture_id")
    private String lectureId;
    
    @Column(name = "lecture_name")
    private String lectureName;
    
    @Column(name = "user_id")
    private int userId;
}
