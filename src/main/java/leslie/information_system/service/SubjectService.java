package leslie.information_system.service;

import leslie.information_system.entity.Subject;

import java.util.List;

public interface SubjectService {

    //遍历所有科目
    public List<Subject> getAllSubject();

    //根据系遍历科目
    public List<Subject> getSubjectByDepartment_id(Integer department_id);

    //根据id
    public Subject getSubjectBySubject_id(Integer subject_id);

    //增加科目
    public void addSubject(Subject subject);

    //删除科目
    public void deleteSubject(Integer subject_id);

    //修改科目
    public void updateSubject(Subject subject);
}
