package leslie.information_system;

import leslie.information_system.entity.Department;
import leslie.information_system.entity.DepartmentAdmin;
import leslie.information_system.entity.Grade;
import leslie.information_system.entity.Subject;
import leslie.information_system.exception.DepartmentAdminException;
import leslie.information_system.mapper.DepartmentAdminMapper;
import leslie.information_system.mapper.DepartmentMapper;
import leslie.information_system.mapper.GradeMapper;
import leslie.information_system.mapper.SubjectMapper;
import leslie.information_system.service.DepartmentAdminService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

@SpringBootTest
class InformationSystemApplicationTests {

//    @Autowired
//    private DepartmentMapper departmentMapper;

//    @Autowired
//    private SubjectMapper subjectMapper;

//    @Autowired
//    private GradeMapper gradeMapper;

//    @Autowired
//    private DepartmentAdminMapper departmentAdminMapper;

    @Autowired
    private DepartmentAdminService departmentAdminService;

    @Test
    void contextLoads() {
        DepartmentAdmin departmentAdmin = new DepartmentAdmin();
        departmentAdmin.setDepartmentAdmin_username("leslie");
        departmentAdmin.setDepartmentAdmin_password("123");

        try {
            DepartmentAdmin login = departmentAdminService.login(departmentAdmin);

            System.out.println(login);
        } catch (DepartmentAdminException e) {
            System.out.println(e.getMessage());
        }
    }

}
