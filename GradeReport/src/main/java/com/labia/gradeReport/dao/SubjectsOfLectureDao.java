/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.labia.gradeReport.dao;

import com.labia.gradeReport.common.CommonSearchColumn;
import com.labia.gradeReport.dto.reponse.SubjectsOfLecture;
import com.labia.gradeReport.dto.reponse.SubjectsOfStudent;
import com.labia.gradeReport.utils.Utils;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

/**
 *
 * @author nhhuy05
 */
@Repository
@RequiredArgsConstructor
public class SubjectsOfLectureDao extends CommonSearchColumn {

    public static final String getSubjectsOfLecture
            = "select grade_report.lecture.lecture_id as lectureId,"
            + "grade_report.lecture.lecture_name as lectureName, "
            + "grade_report.lecture.user_id as userId, "
            + "grade_report.lecture_subject.subject_code as subjectCode,"
            + "grade_report.subjects.term_id as termId\n"
            + "from grade_report.lecture join grade_report.lecture_subject \n"
            + "on grade_report.lecture.lecture_id = grade_report.lecture_subject.lecture_id \n"
            + "join grade_report.subjects on grade_report.subjects.subject_code = grade_report.lecture_subject.subject_code\n"
            + "where grade_report.lecture.lecture_id = :lectureId";

    private final EntityManagerDao entityManager;

    public List<SubjectsOfLecture> getSubjectsOfLecture(String lectureId) {
        Session session = entityManager.session();
        String sql = getSubjectsOfLecture;
        NativeQuery<SubjectsOfLecture> query = session.createNativeQuery(sql.toString());
        setParameterString(query, "lectureId", lectureId);
        session.close();
        session.clear();
        Utils.addScalar(query, SubjectsOfLecture.class);
        return query.getResultList();
    }
}
