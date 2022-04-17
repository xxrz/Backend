package com.test.mapper;

import com.test.pojo.Student;
import com.test.pojo.Teacher;
import com.test.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TeacherMapperTest {


    @Test
    public void getTeacher() {
        // 1.获取执行sal的对象sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2.获取并执行sql语句 方法：getMapper
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher(1);
        System.out.println(teacher);

        // 3.关闭sqlSession连接
        sqlSession.close();
    }

    @Test
    public void getTeacher1() {
        // 1.获取执行sal的对象sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2.获取并执行sql语句 方法：getMapper
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacher1(1);
        System.out.println(teacher);

        // 3.关闭sqlSession连接
        sqlSession.close();
    }

}