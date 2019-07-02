package com.bjtuxxq.demo;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class UserController {
    /*
    登录
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if(!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("username", username);
            session.setAttribute("userType","user");
            return "redirect:/hello";
        }
        else {
            return "/login";
        }
    }
    /*
    注册
     */
    @RequestMapping("/regist")
    public String regist(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        if(password.equals(repassword)){
            User registUserTest = new User(username,"123456",password,"test","user");
            session.setAttribute("user",registUserTest);
            return "/login";
        }else
            return "/regist";
    }
    /*
    登出
     */
    @RequestMapping("/logout")
    public String logout(){
        return "logout";
    }
    /*
    用户主页
     */
    @RequestMapping("/userHome")
    public void userHome(){

    }
    /*
    用户购书记录
     */
    @RequestMapping("/userHome/myBook")
    public void myBook(){

    }

}
