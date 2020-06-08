package leslie.information_system.mapper;

import leslie.information_system.entity.Department;

import java.util.List;

public interface DepartmentMapper {
    //查找所以系
    public List<Department> getAllDepartment();

    //根据系id查找
    public Department getDepartmentByDepartment_id(Integer department_id);

    //根据系名字来查找系
    public Department getDepartmentByDepartment_name(String department_name);

    //添加系
    public void addDepartment(Department department);

    //删除系
    public void deleteDepartment(Integer department_id);

}
