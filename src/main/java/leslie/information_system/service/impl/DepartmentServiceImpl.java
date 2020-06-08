package leslie.information_system.service.impl;

import leslie.information_system.entity.Department;
import leslie.information_system.entity.Student;
import leslie.information_system.entity.Subject;
import leslie.information_system.exception.DepartmentException;
import leslie.information_system.mapper.DepartmentMapper;
import leslie.information_system.mapper.StudentMapper;
import leslie.information_system.mapper.SubjectMapper;
import leslie.information_system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public List<Department> getAllDepartment() {
        List<Department> allDepartment = departmentMapper.getAllDepartment();

        return allDepartment;
    }

    @Override
    public Department getDepartmentByDepartment_id(Integer department_id) {
        Department departmentByDepartment_id = departmentMapper.getDepartmentByDepartment_id(department_id);

        return departmentByDepartment_id;
    }

    @Override
    public Department getDepartmentByDepartment_name(String department_name) {
        Department departmentByDepartment_name = departmentMapper.getDepartmentByDepartment_name(department_name);

        return departmentByDepartment_name;
    }

    @Override
    public void addDepartment(Department department) throws DepartmentException {
        Department departmentByDepartment_name = departmentMapper.getDepartmentByDepartment_name(department.getDepartment_name());

        if (departmentByDepartment_name != null)

            throw new DepartmentException("该系已经存在，请不要重复添加");

        departmentMapper.addDepartment(department);
    }

    @Override
    public void deleteDepartment(Integer department_id){

        departmentMapper.deleteDepartment(department_id);

    }

}
