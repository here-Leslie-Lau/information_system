package leslie.information_system.service.impl;

import leslie.information_system.entity.Admin;
import leslie.information_system.exception.AdminException;
import leslie.information_system.mapper.AdminMapper;
import leslie.information_system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(Admin admin) throws AdminException {
        Admin adminByAdmin_username = adminMapper.getAdminByAdmin_username(admin.getAdmin_username());

        if (adminByAdmin_username == null)
            throw new AdminException("用户名错误");

        if (!adminByAdmin_username.getAdmin_password().equals(admin.getAdmin_password()))
            throw new AdminException("密码错误");

        return adminByAdmin_username;
    }
}
