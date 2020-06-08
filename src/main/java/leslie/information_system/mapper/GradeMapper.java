package leslie.information_system.mapper;

import leslie.information_system.entity.Grade;

import java.util.List;

public interface GradeMapper {

    //根据id查询成绩
    public Grade getGradeByGrade_id(Integer grade_id);

    //根据学生id查询成绩
    public List<Grade> getGradeBy_student_id(Integer student_id);

    //根据科目id查询成绩
    public List<Grade> getGradeBy_Subject_id(Integer subject_id);

    //修改成绩
    public Integer updateGrade(Grade grade);

    //根据id删除某一条成绩
    public void deleteGrade(Integer grade_id);

    //添加成绩记录
    public Integer addGrade(Grade grade);

    //根据学生id，从而删除该学生的所有成绩信息
    public void deleteGradeByStudent_id(Integer student_id);

    //根据科目id删除所有相关成绩
    public void deleteGradeBySubject_id(Integer subject_id);
}
