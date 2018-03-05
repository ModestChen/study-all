package com.hfut.study.web.manager.controller;


import com.hfut.study.web.manager.Girl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 测试控制器
 * Created by Administrator on 2017/6/16.
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    @Autowired
    private Girl girl;

    @Value("${girl.name}")
    private String name;

    /**
     * 测试
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/hello")
    public String queryPageList(Model model, HttpSession session) {
        return "hello";
    }
}
