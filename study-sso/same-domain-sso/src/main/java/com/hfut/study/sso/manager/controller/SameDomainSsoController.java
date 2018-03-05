package com.hfut.study.sso.manager.controller;


import com.hfut.study.sso.api.entity.UserInfo;
import com.hfut.study.sso.server.util.SSOServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chenjia
 * @create 2018-02-06 13:48
 * @desc 同域单点登录控制器
 **/
@Controller
@RequestMapping(value = "/same/domain/sso")
public class SameDomainSsoController {
    //    统一登录接口
    @RequestMapping(value = "/dologin")
    public String dologin(UserInfo userInfo, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (SSOServer.checkLogin(userInfo)) {
            Cookie cookie = new Cookie("ssocookie", "sso");
            cookie.setPath("/");
            response.addCookie(cookie);

            model.addAttribute("result", userInfo);

            return "redirect:"+userInfo.getGotoUrl();
        } else {
            return "login";
        }
    }
}
