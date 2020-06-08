package leslie.information_system.controller;

import leslie.information_system.entity.Department;
import leslie.information_system.entity.Subject;
import leslie.information_system.service.DepartmentService;
import leslie.information_system.service.GradeService;
import leslie.information_system.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private DepartmentService departmentService;


    @GetMapping("/subject")
    public String getAll(HttpServletRequest request){
        List<Subject> allSubject = subjectService.getAllSubject();

        request.setAttribute("subjectList",allSubject);

        List<Department> allDepartment = departmentService.getAllDepartment();

        request.setAttribute("departmentList",allDepartment);

        return "adminPages/subjectList";
    }

    @GetMapping("/subject/{department_id}")
    public String getByDepartment_name(HttpServletRequest request, @PathVariable Integer department_id,@RequestParam("baseHtmlName") String baseHtmlName){
        List<Subject> subjectByDepartment_id = subjectService.getSubjectByDepartment_id(department_id);

        request.setAttribute("subjectList",subjectByDepartment_id);

        return baseHtmlName+"/subjectList";
    }

    @PostMapping("/subject")
    public String add(Subject subject,@RequestParam("department_id") Integer department_id){
        Department departmentByDepartment_id = departmentService.getDepartmentByDepartment_id(department_id);

        subject.setDepartment(departmentByDepartment_id);

        subjectService.addSubject(subject);

        return "adminPages/index";
    }

    @DeleteMapping("/subject")
    public String delete(@RequestParam("subject_id") Integer subject_id){

        subjectService.deleteSubject(subject_id);

        return "adminPages/index";
    }

    @PutMapping("/subject")
    public String update(Subject subject){
        subjectService.updateSubject(subject);

        return "adminPages/index";
    }
}
