package leslie.information_system.service.impl;

import leslie.information_system.entity.Department;
import leslie.information_system.entity.DepartmentAdmin;
import leslie.information_system.exception.DepartmentAdminException;
import leslie.information_system.exception.DepartmentException;
import leslie.information_system.mapper.DepartmentAdminMapper;
import leslie.information_system.service.DepartmentAdminService;
import leslie.information_system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentAdminServiceImpl implements DepartmentAdminService {

    @Autowired
    private DepartmentAdminMapper departmentAdminMapper;


    @Override
    public DepartmentAdmin login(DepartmentAdmin departmentAdmin) throws DepartmentAdminException {
        DepartmentAdmin departmentAdminByDepartmentAdmin_username = departmentAdminMapper.getDepartmentAdminByDepartmentAdmin_username(departmentAdmin.getDepartmentAdmin_username());

        if (departmentAdminByDepartmentAdmin_username == null)
            throw new DepartmentAdminException("用户名错误");

        if (!departmentAdmin.getDepartmentAdmin_password().equals(departmentAdminByDepartmentAdmin_username.getDepartmentAdmin_password()))
            throw new DepartmentAdminException("密码错误");

        return departmentAdminByDepartmentAdmin_username;
    }

    @Override
    public void addDepartmentAdmin(DepartmentAdmin departmentAdmin) throws DepartmentAdminException{
        DepartmentAdmin departmentAdminByDepartmentAdmin_username = departmentAdminMapper.getDepartmentAdminByDepartmentAdmin_username(departmentAdmin.getDepartmentAdmin_username());

        if (departmentAdminByDepartmentAdmin_username != null)
            throw new DepartmentAdminException("用户已经存在，请重新添加");

        departmentAdminMapper.addDepartmentAdmin(departmentAdmin);

    }

    @Override
    public void deleteDepartmentAdmin(Integer departmentAdmin_id) {
        departmentAdminMapper.deleteDepartmentAdmin(departmentAdmin_id);

    }

    @Override
    public List<DepartmentAdmin> getAllDepartmentAdmin() {
        List<DepartmentAdmin> allDepartmentAdmin = departmentAdminMapper.getAllDepartmentAdmin();

        return allDepartmentAdmin;
    }

    @Override
    public void updateDepartmentAdmin(DepartmentAdmin departmentAdmin) {
        departmentAdminMapper.updateDepartmentAdmin(departmentAdmin);

    }

    @Override
    public List<DepartmentAdmin> getDepartmentAdminByDepartment_id(Integer department_id) {
        List<DepartmentAdmin> departmentAdminByDepartment_id = departmentAdminMapper.getDepartmentAdminByDepartment_id(department_id);

        return departmentAdminByDepartment_id;
    }
}
