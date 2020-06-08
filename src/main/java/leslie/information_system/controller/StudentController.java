package leslie.information_system.controller;

import leslie.information_system.entity.Department;
import leslie.information_system.entity.Student;
import leslie.information_system.exception.StudentException;
import leslie.information_system.service.DepartmentService;
import leslie.information_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    private StudentService studentService;

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/student/regist")
    public String regist(Student student, HttpServletRequest request){
        try {
            studentService.regist(student);

            //因为一些后期bug，所以这里先设置部门号为0，即为空。
            Department departmentByDepartment_id = departmentService.getDepartmentByDepartment_id(0);
            System.out.println(departmentByDepartment_id);
            student.setDepartment(departmentByDepartment_id);
            System.out.println(student);
            studentService.update(student);

            //发送激活邮件
            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom("804738464@qq.com");
            message.setTo(student.getStudent_email());
            message.setSubject("学生信息系统激活邮件");
            message.setText("<html><body><h1>您好,"+student.getStudent_username()+"</h1><a href='http://localhost:8080/student/active/"+student.getStudent_id()+"'>请点击进行激活</a></body></html>");

            request.setAttribute("msg","激活邮件已经发送，请注意查看");

            javaMailSender.send(message);

        } catch (StudentException e) {
            request.setAttribute("msg",e.getMessage());
            return "studentPages/regist";
        }

        return "studentPages/login";
    }

    @ResponseBody
    @GetMapping("/student/active/{student_id}")
    public String acitve(@PathVariable Integer student_id){
        studentService.active(student_id);

        return "激活成功，请回到登录页面进行登录";
    }

    @PostMapping("/student/login")
    public String login(Student student,HttpServletRequest request){
        try {
            Student login = studentService.login(student);

            request.getSession().setAttribute("student",login);
        } catch (StudentException e) {
            request.setAttribute("msg",e.getMessage());
            return "studentPages/login";
        }

        return "index";
    }

    @GetMapping("/student/quit")
    public String quit(Integer student_id,HttpServletRequest request){
        request.getSession().removeAttribute("student");

        return "studentPages/login";
    }

    @PutMapping("/student/update")
    public String update(Student student,Integer department_id,HttpServletRequest request){


        Department departmentByDepartment_id = departmentService.getDepartmentByDepartment_id(department_id);

        student.setDepartment(departmentByDepartment_id);

        studentService.update(student);

        request.getSession().setAttribute("student",student);

        return "studentPages/changeInformation";
    }

    //根据系id查询所以学生
    @GetMapping("/student/{department_id}")
    public String getStudentByDepartment_id(@PathVariable Integer department_id,HttpServletRequest request){
        List<Student> studentByDepartment_id = studentService.getStudentByDepartment_id(department_id);

        request.setAttribute("studentList",studentByDepartment_id);

        return "departmentAdminPages/studentList";
    }

    @DeleteMapping("/student")
    public String deleteStudent(@RequestParam("student_id") Integer student_id){
        System.out.println(student_id);

        Student student = studentService.getStudentByStudent_id(student_id);

        //发送删除告知邮件
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("804738464@qq.com");
        message.setTo(student.getStudent_email());
        message.setSubject("学生信息系统告知邮件");
        message.setText("<html><body><h1>您好,"+student.getStudent_name()+"</h1><br/>系管理员当前已将你的账户信息与成绩信息清空，如有疑问，请联系相关的系管理员");


        javaMailSender.send(message);

        studentService.deleteStudent(student_id);

        return "/departmentAdminPages/index";
    }

    //忘记密码
    @PostMapping("/student/forgetPassword")
    public String forgetPassword(@RequestParam("student_username") String student_username,HttpServletRequest request){
        Student studentByStudent_name = studentService.getStudentByStudent_name(student_username);

        if (studentByStudent_name == null){
            request.setAttribute("msg","该用户名不存在，或者已经被系管理员删除");
            return "studentPages/login";
        }

        //发送密码告知邮件
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("804738464@qq.com");
        message.setTo(studentByStudent_name.getStudent_email());
        message.setSubject("学生信息系统告知邮件");
        message.setText("<html><body><h1>您好,"+studentByStudent_name.getStudent_name()+"</h1><br/>你的密码为:"+studentByStudent_name.getStudent_password());

        javaMailSender.send(message);

        request.setAttribute("msg","邮件已发送");

        return "studentPages/login";
    }
}
