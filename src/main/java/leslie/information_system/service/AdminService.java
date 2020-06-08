package leslie.information_system.service;

import leslie.information_system.entity.Admin;
import leslie.information_system.exception.AdminException;

public interface AdminService {

    //登录
    public Admin login(Admin admin) throws AdminException;
}
