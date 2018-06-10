package com.hfut.study.mybatis.service.impl;


import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hfut.study.mybatis.dao.StudentMapper;
import com.hfut.study.mybatis.entity.Student;
import com.hfut.study.mybatis.service.IStudentService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author chenjia
 * @since 2018-05-05
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

}
