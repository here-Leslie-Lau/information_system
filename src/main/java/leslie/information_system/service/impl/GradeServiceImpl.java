package leslie.information_system.service.impl;

import leslie.information_system.entity.Grade;
import leslie.information_system.mapper.GradeMapper;
import leslie.information_system.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    public List<Grade> getGradeByStudent_id(Integer student_id) {
        List<Grade> gradeBy_student_id = gradeMapper.getGradeBy_student_id(student_id);

        return gradeBy_student_id;
    }

    @Override
    public List<Grade> getGradeBySubject_id(Integer subject_id) {
        List<Grade> gradeBy_subject_id = gradeMapper.getGradeBy_Subject_id(subject_id);

        return gradeBy_subject_id;
    }

    @Override
    public Grade getGradeByGrade_id(Integer grade_id) {
        Grade gradeByGrade_id = gradeMapper.getGradeByGrade_id(grade_id);

        return gradeByGrade_id;
    }

    @Override
    public void updateGrade(Grade grade) {
        gradeMapper.updateGrade(grade);

    }

    @Override
    public void deleteGrade(Integer grade_id) {
        gradeMapper.deleteGrade(grade_id);

    }

    @Override
    public void addGrade(Grade grade) {
        gradeMapper.addGrade(grade);

    }
}
