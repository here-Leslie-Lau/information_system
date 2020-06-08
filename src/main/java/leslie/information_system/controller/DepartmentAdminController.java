package leslie.information_system.controller;

import leslie.information_system.entity.Department;
import leslie.information_system.entity.DepartmentAdmin;
import leslie.information_system.exception.DepartmentAdminException;
import leslie.information_system.service.DepartmentAdminService;
import leslie.information_system.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/departmentAdmin")
public class DepartmentAdminController {

    @Autowired
    private DepartmentAdminService departmentAdminService;

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/login")
    public String login(DepartmentAdmin departmentAdmin, HttpServletRequest request){

        try {
            DepartmentAdmin login = departmentAdminService.login(departmentAdmin);

            request.getSession().setAttribute("departmentAdmin",login);
        } catch (DepartmentAdminException e) {
            request.setAttribute("msg",e.getMessage());
            return "departmentAdminPages/login";
        }

        return "departmentAdminPages/index";
    }

    @GetMapping("/quit")
    public String quit(HttpServletRequest request){
        request.getSession().removeAttribute("studentlogin.departmentAdmin");

        return "departmentAdminPages/login";
    }

    //获取所有
    //同时因为添加系管理员这一需求，需要遍历所有系，所以顺便把所有系也放入request域中
    @GetMapping("/getAll")
    public String getAll(HttpServletRequest request){
        List<DepartmentAdmin> allDepartmentAdmin = departmentAdminService.getAllDepartmentAdmin();

        request.setAttribute("departmentAdminList",allDepartmentAdmin);

        List<Department> allDepartment = departmentService.getAllDepartment();

        request.setAttribute("departmentList",allDepartment);

        return "adminPages/departmentAdminList";
    }

    //添加系管理员
    @PostMapping("/add")
    public String add(DepartmentAdmin departmentAdmin, @RequestParam("department_id") Integer department_id, HttpServletRequest request){
        Department departmentByDepartment_id = departmentService.getDepartmentByDepartment_id(department_id);

        departmentAdmin.setDepartment(departmentByDepartment_id);

        try {
            departmentAdminService.addDepartmentAdmin(departmentAdmin);
        } catch (DepartmentAdminException e) {
            request.setAttribute("msg",e.getMessage());
        }

        return "adminPages/index";
    }

    //删除
    @DeleteMapping("/delete")
    public String delete(@RequestParam("departmentAdmin_id") Integer departmentAdmin_id){

        departmentAdminService.deleteDepartmentAdmin(departmentAdmin_id);

        return "adminPages/index";
    }

    //修改系管理员
    @PutMapping("/update")
    public String update(DepartmentAdmin departmentAdmin){

        departmentAdminService.updateDepartmentAdmin(departmentAdmin);

        return "adminPages/index";
    }
}
