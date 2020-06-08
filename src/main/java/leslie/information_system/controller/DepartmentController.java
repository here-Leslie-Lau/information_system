package leslie.information_system.controller;

import leslie.information_system.entity.Department;
import leslie.information_system.entity.DepartmentAdmin;
import leslie.information_system.entity.Student;
import leslie.information_system.entity.Subject;
import leslie.information_system.exception.DepartmentException;
import leslie.information_system.service.DepartmentAdminService;
import leslie.information_system.service.DepartmentService;
import leslie.information_system.service.StudentService;
import leslie.information_system.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private DepartmentAdminService departmentAdminService;

    //遍历所有部门，将结果保存到request域中,并通过jquery结合转发到对应标记处
    @GetMapping("/get")
    public String getAllDepartment(HttpServletRequest request,String htmlName){
        List<Department> allDepartment = departmentService.getAllDepartment();

        request.setAttribute("allDepartment",allDepartment);


        return htmlName+"::department";
    }

    @PostMapping("/add")
    public String addDepartment(Department department, HttpServletRequest request,HttpServletResponse response){
        try {
            departmentService.addDepartment(department);

        } catch (DepartmentException e) {
            request.setAttribute("msg",e.getMessage());
        }

        return "adminPages/index";
    }

    //删除前先判断外键是否还存在
    @DeleteMapping("/delete/{department_id}")
    public String deleteDepartment(@PathVariable("department_id") Integer department_id,HttpServletRequest request){
        List<Student> studentByDepartment_id = studentService.getStudentByDepartment_id(department_id);

        if (studentByDepartment_id.size() != 0){
            request.setAttribute("msg","该系下仍然有学生，删除失败,如要删除请联系相关系管理员删除学生信息");

            return "adminPages/index";
        }

        List<Subject> subjectByDepartment_id = subjectService.getSubjectByDepartment_id(department_id);

        if (subjectByDepartment_id.size() != 0){
            request.setAttribute("msg","该系下仍然有相关科目信息，如要删除该系,请先删除相关科目再删除该系");

            return "adminPages/index";

        }

        List<DepartmentAdmin> departmentAdminByDepartment_id = departmentAdminService.getDepartmentAdminByDepartment_id(department_id);

        if (departmentAdminByDepartment_id.size() != 0){
            request.setAttribute("msg","该系下仍然有相关的系管理员，如要删除该系,请先删除相关系管理员再删除该系");
        }

        departmentService.deleteDepartment(department_id);

        return "adminPages/index";
    }


    //遍历部门
    @GetMapping("/getAll")
    public String getAll(HttpServletRequest request){
        List<Department> allDepartment = departmentService.getAllDepartment();

        request.setAttribute("departmentList",allDepartment);

        return "adminPages/departmentList";
    }

}
