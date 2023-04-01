package com.labia.gradeReport.dao;

import com.labia.gradeReport.common.CommonSearchColumn;
import com.labia.gradeReport.dto.reponse.SubjectsOfStudent;
import com.labia.gradeReport.utils.Utils;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SubjectsOfStudentDao extends CommonSearchColumn {
    public static final String SubjectsOfStudent =
            "SELECT distinct c.curriculum_id as curriculumId, " +
                    "c.curriculum_code as curriculumCode, " +
                    "c.curriculum_name as curriculumName, " +
                    "t.term_id as termId, " +
                    "t.term_no as termNo, " +
                    "s.subject_code as subjectCode, " +
                    "s.subject_name as subjectName, " +
                    "s.credits as credits" +
                    " FROM curriculums c \n" +
            "LEFT JOIN term t on t.curriculum_id = c.curriculum_id \n" +
            "LEFT JOIN subjects s on s.term_id = t.term_id \n" +
            "WHERE c.curriculum_id = :curriculumId";
    private final EntityManagerDao entityManager;

    public List<SubjectsOfStudent> getSubjectsOfStudents(Integer curriculumId){
        Session session = entityManager.session();
        String sql = SubjectsOfStudent;
        NativeQuery<SubjectsOfStudent> query = session.createNativeQuery(sql.toString());
        setParameterInteger(query, "curriculumId", curriculumId);
        session.close();
        session.clear();
        Utils.addScalar(query, SubjectsOfStudent.class);
        return query.getResultList();
    }
}
