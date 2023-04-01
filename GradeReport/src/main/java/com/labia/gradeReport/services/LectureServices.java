/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.labia.gradeReport.services;

import com.labia.gradeReport.dao.StudentsOfSubjectTermDao;
import com.labia.gradeReport.dao.SubjectsOfLectureDao;
import com.labia.gradeReport.dto.reponse.StudentsOfSubjectTerm;
import com.labia.gradeReport.dto.reponse.SubjectsOfLecture;
import com.labia.gradeReport.models.Lecture;
import com.labia.gradeReport.repository.LectureRepository;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 *
 * @author nhhuy05
 */
@Service
@RequiredArgsConstructor
public class LectureServices {

    private final SubjectsOfLectureDao subjectsOfLectureDao;
    private final StudentsOfSubjectTermDao studentsOfSubjectTermDao;
    private final LectureRepository lectureRepository;

    public List<SubjectsOfLecture> subjectsOfLecture(String lectureId) {
        List<SubjectsOfLecture> list = subjectsOfLectureDao.getSubjectsOfLecture(lectureId);
        if (list == null) {
            throw new NullPointerException("Subject Of Lecture is Null !!!");
        }
        return list;
    }
    
    public List<StudentsOfSubjectTerm> studentsOfSubjectTerm(String subjectCode,String assessmentType) {
        List<StudentsOfSubjectTerm> list = studentsOfSubjectTermDao.getStudentsOfSubjectTerm(subjectCode,assessmentType);
        if (list == null) {
            throw new NullPointerException("List Students of SubjectTerm is Null !!!");
        }
        return list;
    }

    public Lecture getLectureByUserId(Integer userId) {
        Optional<Lecture> lecture = lectureRepository.findByUserId(userId);
        if (!lecture.isPresent()) {
            throw new NullPointerException("Can't find Lecture");
        }
        return lecture.get();
    }
    
    
}
