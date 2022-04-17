package com.test.mapper;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import com.test.mapper.StudentMapper;
import com.test.pojo.Student;
import com.test.utils.MybatisUtils;

import java.util.List;

public class StudentMapperTest {

    @Test
    public void getStudents () {
        // 1.获取执行sal的对象sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2.获取并执行sql语句 方法：getMapper
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudents();
        for (Student student : students) {
            System.out.println(student);
        }
        // 3.关闭sqlSession连接
        sqlSession.close();
    }


    @Test
    public void getStudents1 () {
        // 1.获取执行sal的对象sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2.获取并执行sql语句 方法：getMapper
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.getStudents1();
        for (Student student : students) {
            System.out.println(student);
        }
        // 3.关闭sqlSession连接
        sqlSession.close();
    }
}
