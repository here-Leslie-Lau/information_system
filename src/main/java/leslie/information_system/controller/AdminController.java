package leslie.information_system.controller;

import leslie.information_system.entity.Admin;
import leslie.information_system.exception.AdminException;
import leslie.information_system.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    //登录
    @PostMapping("/login")
    public String login(Admin admin, HttpServletRequest request){
        try {
            Admin login = adminService.login(admin);

            request.getSession().setAttribute("admin",login);
        } catch (AdminException e) {
            request.setAttribute("msg",e.getMessage());
            return "adminPages/login";
        }

        return "adminPages/index";
    }

    //退出登录
    @GetMapping("/quit")
    public String quit(HttpServletRequest request){
        request.getSession().removeAttribute("admin");

        return "adminPages/login";
    }
}
