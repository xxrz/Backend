package com.test.mapper;

import com.test.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {
    int addBlog(Blog blog);

    //查询博客
    List<Blog> quarrBlogs(Map map);

}
