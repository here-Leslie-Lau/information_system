package leslie.information_system.service.impl;

import leslie.information_system.entity.Subject;
import leslie.information_system.mapper.GradeMapper;
import leslie.information_system.mapper.SubjectMapper;
import leslie.information_system.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    public SubjectMapper subjectMapper;

    @Autowired
    private GradeMapper gradeMapper;

    @Override
    @Cacheable("subjectList")
    public List<Subject> getAllSubject() {
        List<Subject> allSubject = subjectMapper.getAllSubject();

        return allSubject;
    }

    @Override
    @Cacheable("subjectListByDepartment_id")
    public List<Subject> getSubjectByDepartment_id(Integer department_id) {
        List<Subject> subjectByDepartment_id = subjectMapper.getSubjectByDepartment_id(department_id);

        return subjectByDepartment_id;
    }

    @Override
    public Subject getSubjectBySubject_id(Integer subject_id) {
        Subject subjectBySubject_id = subjectMapper.getSubjectBySubject_id(subject_id);

        return subjectBySubject_id;
    }

    @Override
    @CacheEvict({"subjectListByDepartment_id","subjectList"})
    public void addSubject(Subject subject) {
        subjectMapper.addSubject(subject);
    }

    @Override
    @CacheEvict({"subjectListByDepartment_id","subjectList"})
    public void deleteSubject(Integer subject_id) {
        gradeMapper.deleteGradeBySubject_id(subject_id);

        subjectMapper.deleteSubject(subject_id);
    }

    @Override
    @CacheEvict({"subjectListByDepartment_id","subjectList"})
    public void updateSubject(Subject subject) {
        subjectMapper.updateSubject(subject);
    }
}
