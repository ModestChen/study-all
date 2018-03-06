package com.hfut.study.sso.manager.controller;

import com.hfut.study.sso.client.util.SSOClient;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author chenjia
 * @create 2018-02-06 15:23
 * @desc
 **/
@Controller
@RequestMapping(value = "demo1")
public class Demo1Controller {
    private String gotoUrl;
    @RequestMapping(value = "/main")
    public String main(Model model, HttpServletRequest request) {
        if (SSOClient.chickCookie(request)) {
            return "success1";
        }
        gotoUrl = "/demo1/main";
        model.addAttribute("gotoUrl", gotoUrl);
        return "login";
    }
}
