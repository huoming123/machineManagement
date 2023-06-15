package com.design.machineManagement.mapper;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Course;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Course)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-21 17:21:20
 */
public interface CourseMapper {

      //分页查询
    List<Course> getPageListByCondition(@Param("page") Page<Course> page);

    void add(Course course);

    Integer getPageListCount(@Param("page") Page<Course> page);

    void update(Course course);

    void delete(Integer id);

    List<Course> getAllList();
}
