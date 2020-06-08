package leslie.information_system.service;

import leslie.information_system.entity.Grade;

import java.util.List;

public interface GradeService {

    //根据学生id查询成绩
    public List<Grade> getGradeByStudent_id(Integer student_id);

    //根据科目id来查询成绩
    public List<Grade> getGradeBySubject_id(Integer subject_id);

    //根据id查询
    public Grade getGradeByGrade_id(Integer grade_id);

    //修改学生成绩
    public void updateGrade(Grade grade);

    //删除某一条成绩
    public void deleteGrade(Integer grade_id);

    //添加一条成绩
    public void addGrade(Grade grade);
}
