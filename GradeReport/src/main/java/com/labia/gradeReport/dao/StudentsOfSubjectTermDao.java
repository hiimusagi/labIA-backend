/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.labia.gradeReport.dao;

import com.labia.gradeReport.common.CommonSearchColumn;
import com.labia.gradeReport.dto.reponse.StudentsOfSubjectTerm;
import com.labia.gradeReport.dto.reponse.SubjectsOfLecture;
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
public class StudentsOfSubjectTermDao extends CommonSearchColumn {

    public static final String getStudentsOfSubjectTerm
            = "select \n"
            + "student_name as studentName, \n"
            + "grade_report.student.student_id as studentId,\n"
            + "grade_report.curriculums.curriculum_id as curriculumId,\n"
            + "curriculum_code as curriculumCode,\n"
            + "grade_report.subjects.subject_code as subjectCode,\n"
            + "grade_report.term.term_id as termId,\n"
            + "grade_report.assessments.assessment_type as assessmentType,\n"
            + "MAX(grade_report.assessments.assessment_grade) AS assessmentGrade\n"
            + "from grade_report.student \n"
            + "join grade_report.curriculums on grade_report.student.curriculum_id = grade_report.curriculums.curriculum_id\n"
            + "join grade_report.term on grade_report.term.curriculum_id = grade_report.curriculums.curriculum_id\n"
            + "join grade_report.subjects on grade_report.subjects.term_id = grade_report.term.term_id\n"
            + "join grade_report.assessments on grade_report.assessments.student_id = grade_report.student.student_id\n"
            + "where grade_report.subjects.subject_code = :subjectCode\n"
            + "and grade_report.assessments.assessment_type = :assessmentType\n"
            + "group by grade_report.student.student_id\n"
            + "order by grade_report.student.student_id;";

    private final EntityManagerDao entityManager;

    public List<StudentsOfSubjectTerm> getStudentsOfSubjectTerm(String subjectCode, String assessmentType) {
        Session session = entityManager.session();
        String sql = getStudentsOfSubjectTerm;
        NativeQuery<StudentsOfSubjectTerm> query = session.createNativeQuery(sql.toString());
        setParameterString(query, "subjectCode", subjectCode);
        setParameterString(query, "assessmentType", assessmentType);
        session.close();
        session.clear();
        Utils.addScalar(query, StudentsOfSubjectTerm.class);
        return query.getResultList();
    }

}
