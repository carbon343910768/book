package com.bjtuxxq.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {
    /*
    管理员主页
    功能：
     */
    @RequestMapping("/Admin")
    public void AdminHome(){

    }
    /*
    管理员数据管理页
    功能：
     */
    @RequestMapping("/Admin/data")
    public void Data(){

    }
}
