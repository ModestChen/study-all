package com.hfut.study.web.manager.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    protected final static Logger logger = LoggerFactory.getLogger(WebManagerApp.class);

    public static void main(String[] args) {
        SpringApplication.run(WebManagerApp.class, args);
        logger.info("PortalApplication is success!");
        System.err.println("sample started. http://localhost:8080/test/student/queryList");
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
