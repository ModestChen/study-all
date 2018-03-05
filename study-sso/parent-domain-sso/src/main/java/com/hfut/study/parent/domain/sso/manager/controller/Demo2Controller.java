package com.hfut.study.parent.domain.sso.manager.controller;

import com.hfut.study.sso.api.entity.UserInfo;
import com.hfut.study.sso.client.util.SSOClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author chenjia
 * @create 2018-02-06 15:23
 * @desc
 **/
@Controller
@RequestMapping(value = "demo2")
public class Demo2Controller {
    private String gotoUrl;
    @RequestMapping(value = "/main")
    public String dologin(Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (SSOClient.COOKIESNAME.equals(cookie.getName())//
                        && SSOClient.COOKIESVALUE.equals(cookie.getValue())) {
                    UserInfo userInfo = new UserInfo();
                    userInfo.setCookiesName(cookie.getName());
                    userInfo.setCookiesValue(cookie.getValue());
                    String result = SSOClient.doGet("http://check.x.com:8080/sso/checkCookies",userInfo);
                    if ("1".equals(result)) {
                        return "success2";
                    } else {
                        break;
                    }
                }
            }
        }
        gotoUrl = "http://demo2.x.com:8080/sso/demo2/main";
        model.addAttribute("gotoUrl", gotoUrl);
        return "login";
    }
}
