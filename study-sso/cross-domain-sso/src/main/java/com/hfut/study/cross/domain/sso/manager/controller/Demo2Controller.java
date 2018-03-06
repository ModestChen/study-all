package com.hfut.study.cross.domain.sso.manager.controller;

import com.hfut.study.sso.api.entity.UserInfo;
import com.hfut.study.sso.client.util.SSOClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author chenjia
 * @create 2018-02-06 15:23
 * @desc
 **/
@Controller
@RequestMapping(value = "demo2")
public class Demo2Controller {
    private String gotoUrl;
    private String path;
    @RequestMapping(value = "/main")
    public String main(Model model, HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (SSOClient.COOKIESNAME.equals(cookie.getName())//
                        && SSOClient.COOKIESVALUE.equals(cookie.getValue())) {
                    UserInfo userInfo = new UserInfo();
                    userInfo.setCookiesName(cookie.getName());
                    userInfo.setCookiesValue(cookie.getValue());
                    String result = SSOClient.doGet("http://check.x.com:8080/sso/checkCookies", userInfo);
                    if ("1".equals(result)) {

                        return "success2";
                    } else {
                        break;
                    }
                }
            }
        }
        gotoUrl = "http://www.b.com:8080/sso/demo2/main";
        path="dologin";
        model.addAttribute("path", path);
        model.addAttribute("gotoUrl", gotoUrl);
        return "login";
    }

    @RequestMapping(value = "/dologin")
    public String doLogin(Model model,UserInfo userInfo) {
        String result = SSOClient.doGet("http://www.x.com:8080/sso/dologin", userInfo);
        if ("1".equals(result)) {
            model.addAttribute("hiddenUrls", SSOClient.hiddenUrls);
            return "success2";
        } else {
            return "login";
        }
    }

    //增加cookies
    @RequestMapping(value = "/addcookie")
    public void addcookies(HttpServletResponse response) {
        Cookie cookie = new Cookie(SSOClient.COOKIESNAME, SSOClient.COOKIESVALUE);
        cookie.setPath("/");
        response.addCookie(cookie);
    }
}
