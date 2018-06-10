package com.hfut.study.web.manager.controller.mybatis;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.hfut.study.mybatis.dao.StudentMapper;
import com.hfut.study.mybatis.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 前端控制�?
 * </p>
 *
 * @author chenjia
 * @since 2018-06-10
 */
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentMapper studentMapper;

    @GetMapping("/queryList")
    public List<Student> queryList(HttpServletResponse response) {
        List<Student> studentList = studentMapper.selectList(new EntityWrapper<Student>());
        return studentList;
    }
}

