package leslie.information_system.mapper;

import leslie.information_system.entity.DepartmentAdmin;

import java.util.List;

public interface DepartmentAdminMapper {

    //根据用户名查找系管理员
    public DepartmentAdmin getDepartmentAdminByDepartmentAdmin_username(String departmentAdmin_username);

    //根据id查找
    public DepartmentAdmin getDepartmentAdminByDepartmentAdmin_id(Integer departmentAdmin_id);

    //添加
    public Integer addDepartmentAdmin(DepartmentAdmin departmentAdmin);

    //根据id删除
    public void deleteDepartmentAdmin(Integer departmentAdmin_id);

    //查询所有系管理员
    public List<DepartmentAdmin> getAllDepartmentAdmin();

    //修改某一系管理员
    public Integer updateDepartmentAdmin(DepartmentAdmin departmentAdmin);

    //根据系id查找系管理员
    public List<DepartmentAdmin> getDepartmentAdminByDepartment_id(Integer department_id);
}
