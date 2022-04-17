package com.test.mapper;

import com.test.pojo.Teacher;
import org.apache.ibatis.annotations.Param;


public interface TeacherMapper {

    Teacher getTeacher(@Param("tid") int id);

    Teacher getTeacher1(int id);
}
