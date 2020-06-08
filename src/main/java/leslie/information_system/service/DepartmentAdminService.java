package leslie.information_system.service;

import leslie.information_system.entity.DepartmentAdmin;
import leslie.information_system.exception.DepartmentAdminException;

import java.util.List;

public interface DepartmentAdminService {
    //登录
    public DepartmentAdmin login(DepartmentAdmin departmentAdmin) throws DepartmentAdminException;

    //添加(比注册严谨)
    public void addDepartmentAdmin(DepartmentAdmin departmentAdmin) throws DepartmentAdminException;

    //删除
    public void deleteDepartmentAdmin(Integer departmentAdmin_id);

    //查询所有
    public List<DepartmentAdmin> getAllDepartmentAdmin();

    //修改
    public void updateDepartmentAdmin(DepartmentAdmin departmentAdmin);

    //根据系查找系管理员
    public List<DepartmentAdmin> getDepartmentAdminByDepartment_id(Integer department_id);
}
