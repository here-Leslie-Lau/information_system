package leslie.information_system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
//用以控制页面跳转
public class PageController {

    @GetMapping(value = {"/login","studentPages/login"})
    public String login(){
        return "studentPages/login";
    }

    @GetMapping(value = {"/regist","studentPages/regist"})
    public String regist(){
        return "studentPages/regist";
    }

    @GetMapping(value = {"/","/index"})
    public String index(){
        return "index";
    }

    @GetMapping(value = "/demo")
    public String demo(){
        return "demo";
    }

    @GetMapping("/student/changeInformation")
    public String changeInformation(){
        return "studentPages/changeInformation";
    }

    @GetMapping("/departmentAdminPages/login")
    public String teacherLogin(){
        return "departmentAdminPages/login";
    }

    @GetMapping("/departmentAdminPages/index")
    public String departmentAdminIndex(){
        return "/departmentAdminPages/index";
    }

    @GetMapping("/departmentAdminPages/informationList")
    public String informationList(){
        return "/departmentAdminPages/informationList";
    }

    @GetMapping("/adminPages/login")
    public String adminLogin(){
        return "adminPages/login";
    }

    @GetMapping("/adminPages/index")
    public String adminIndex(){
        return "adminPages/index";
    }

}
