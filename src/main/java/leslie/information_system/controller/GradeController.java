package leslie.information_system.controller;

import leslie.information_system.entity.DepartmentAdmin;
import leslie.information_system.entity.Grade;
import leslie.information_system.entity.Student;
import leslie.information_system.entity.Subject;
import leslie.information_system.service.GradeService;
import leslie.information_system.service.StudentService;
import leslie.information_system.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/grade")
public class GradeController {

    @Autowired
    private GradeService gradeService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private SubjectService subjectService;

    //查询某个学生的所有成绩，并把结果保存到request域中
    @GetMapping("/student/{student_id}")
    public String getGradeByStudent_id(@PathVariable Integer student_id, HttpServletRequest request){
        List<Grade> gradeByStudent_id = gradeService.getGradeByStudent_id(student_id);

        request.setAttribute("gradeList",gradeByStudent_id);

        return "studentPages/gradeList";
    }

    //为了日后需求，将该系的所有科目保存到request域中,目的是方便添加成绩时，可以直观显示有哪些科目
    //同时将该学生也保存至request域中
    @GetMapping("/departmentAdmin/{student_id}")
    public String getGradeByStudent_idInDepartmentAdmin(@PathVariable Integer student_id, HttpServletRequest request){
        List<Grade> gradeByStudent_id = gradeService.getGradeByStudent_id(student_id);

        request.setAttribute("gradeList",gradeByStudent_id);


        DepartmentAdmin departmentAdmin = (DepartmentAdmin) request.getSession().getAttribute("departmentAdmin");
        List<Subject> subjectByDepartment_id = subjectService.getSubjectByDepartment_id(departmentAdmin.getDepartment().getDepartment_id());
        request.setAttribute("subjectList",subjectByDepartment_id);

        request.setAttribute("requestStudent",studentService.getStudentByStudent_id(student_id));

        return "departmentAdminPages/gradeList";
    }

    //修改学生成绩
    @PutMapping("/update")
    public String updateGrade(Grade grade, @RequestParam("student_username") String student_username){
        Student studentByStudent_name = studentService.getStudentByStudent_name(student_username);

        grade.setStudent(studentByStudent_name);

        gradeService.updateGrade(grade);

        return "departmentAdminPages/informationList";
    }

    // 删除学生成绩
    @DeleteMapping("/delete")
    public String deleteGrade(@RequestParam("grade_id") Integer grade_id){
        gradeService.deleteGrade(grade_id);

        return "departmentAdminPages/index";
    }

    //添加学生成绩
    @PostMapping("/add")
    public String addGrade(Grade grade,@RequestParam("student_id") Integer student_id,@RequestParam("subject_id") Integer subject_id){


        //封装student与subject
        Student studentByStudent_id = studentService.getStudentByStudent_id(student_id);
        grade.setStudent(studentByStudent_id);

        Subject subjectBySubject_id = subjectService.getSubjectBySubject_id(subject_id);
        grade.setSubject(subjectBySubject_id);

        gradeService.addGrade(grade);

        return "departmentAdminPages/index";
    }
}
