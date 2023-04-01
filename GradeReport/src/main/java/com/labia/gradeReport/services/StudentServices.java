package com.labia.gradeReport.services;

import com.labia.gradeReport.dao.SubjectsOfStudentDao;
import com.labia.gradeReport.dto.reponse.SubjectsOfStudent;
import com.labia.gradeReport.models.Student;
import com.labia.gradeReport.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentServices {
    private final SubjectsOfStudentDao subjectsOfStudentDao;
    private final StudentRepository studentRepository;
    public List<SubjectsOfStudent> subjectsOfStudents(Integer curriculumId){
        List<SubjectsOfStudent> list = subjectsOfStudentDao.getSubjectsOfStudents(curriculumId);
        if (list == null){
            throw new NullPointerException("Subject Of Student is Null !!!");
        }
        return list;
    }

    public Student getStudentByUserId(Integer userId){
        Optional<Student> student = studentRepository.findByUserId(userId);
        if (!student.isPresent()){
            throw new NullPointerException("Can't find Student");
        }
        return student.get();
    }
}
