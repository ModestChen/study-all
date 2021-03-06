package com.hfut.study.cross.domain.sso.manager.controller;


import com.hfut.study.sso.api.entity.UserInfo;
import com.hfut.study.sso.server.util.SSOServer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author chenjia
 * @create 2018-02-06 13:48
 * @desc 同域单点登录控制器
 **/
@Controller
@RequestMapping(value = "/sso")
public class SSOController {
    //    统一登录接口
    @RequestMapping(value = "/dologin")
    public String dologin(UserInfo userInfo, Model model, HttpServletRequest request, HttpServletResponse response) {
        if (SSOServer.checkLogin(userInfo)) {
            Cookie cookie = new Cookie("ssocookie", "sso");
//            设置父域
            cookie.setDomain(".x.com");

            cookie.setPath("/");
            response.addCookie(cookie);
            model.addAttribute("result", userInfo);

            return "redirect:" + userInfo.getGotoUrl();
        } else {
            return "login";
        }
    }

    //统一校验接口
    @RequestMapping("checkCookies")
    public void checkCookies(HttpServletRequest request, HttpServletResponse response, String cookiesName, String cookiesValue) throws IOException {
        boolean ok = SSOServer.chickCookie(cookiesName, cookiesValue);
        String result = "0";
        if (ok) {
            result = "1";
        }
        response.getWriter().print(result);
        response.getWriter().close();
    }
}
