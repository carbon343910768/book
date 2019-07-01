package com.bjtuxxq.demo;

import com.bjtuxxq.demo.intercepors.loginIntercepors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


//@Controller hm
public class UserController {
    /*
    登录
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username);
        if(!StringUtils.isEmpty(username) && "123456".equals(password)) {
            session.setAttribute("username", username);
            return "hello";
        }
        else {
            return "login";
        }
    }
    /*
    注册
     */
    @RequestMapping("/regist")
    public String regist(){
        return "regist";
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
