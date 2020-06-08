package leslie.information_system.mapper;

import leslie.information_system.entity.Admin;

public interface AdminMapper {

    //根据用户名查找
    public Admin getAdminByAdmin_username(String admin_username);

    //根据id查找
    public Admin getAdminByAdmin_id(Integer admin_id);


}
