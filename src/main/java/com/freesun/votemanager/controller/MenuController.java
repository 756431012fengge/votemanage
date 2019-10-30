package com.freesun.votemanager.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/menu")
public class MenuController {

    /**
     * 跳转登录界面
     */
    @GetMapping("toLogin")
    public String toLogin(){

        return "/doLogin.html";
    }
    /**
     * 用户退出
     */
    @GetMapping("toLogout")
    public String toLogout(HttpSession session){
        Subject lvSubject= SecurityUtils.getSubject();
        lvSubject.logout();
        return "redirect:/doLogin.html";
    }

    /**
     * 跳转至主页面
     */

    @GetMapping("toMain")
    public String toMain(){

        return "redirect:/voteMain.html";
    }
}
