package com.hfut.study.web.manager.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author chenjia
 * @create 2017-10-22 19:09
 * @desc web服务启动
 **/
@SpringBootApplication
@ComponentScan("${scan.packages}")
public class WebManagerApp {
    public static void main(String[] args) {
        SpringApplication.run(WebManagerApp.class, args);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("========================================================================");
        System.out.println("---------------------测试管理平台 启动成功---------------------------");
        System.out.println("========================================================================");
        System.out.println("------------------------------------------------------------------------");
    }

//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(WebManagerApp.class);
//    }
}
