package com.test.mapper;

import com.test.pojo.Blog;
import com.test.utils.IDUtils;
import com.test.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.Date;


public class BlogMapperTest {


    @Test
    public void addBlog() {
        // 1.获取执行sal的对象sqlSession
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 2.获取并执行sql语句 方法：getMapper
        BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
        Blog blog = new Blog();
        blog.setId(IDUtils.genId());
        blog.setTitle("1====================");
        blog.setAuthor("zhangsan");
        blog.setCreateTime(new Date());
        blog.setViews(9999);

        mapper.addBlog(blog);

        blog.setId(IDUtils.genId());
        blog.setTitle("2====================");
        mapper.addBlog(blog);

        blog.setId(IDUtils.genId());
        blog.setTitle("3====================");
        mapper.addBlog(blog);

        blog.setId(IDUtils.genId());
        blog.setTitle("4====================");
        mapper.addBlog(blog);

        // 3.关闭sqlSession连接
        sqlSession.close();
    }

}