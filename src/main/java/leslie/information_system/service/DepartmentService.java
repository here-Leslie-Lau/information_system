package leslie.information_system.service;

import leslie.information_system.entity.Department;
import leslie.information_system.exception.DepartmentException;

import java.util.List;

public interface DepartmentService {
    public List<Department> getAllDepartment();

    public Department getDepartmentByDepartment_id(Integer department_id);

    public Department getDepartmentByDepartment_name(String department_name);

    //添加系
    public void addDepartment(Department department) throws DepartmentException;

    //删除系
    public void deleteDepartment(Integer department_id);

}
