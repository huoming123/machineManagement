package com.design.machineManagement.service;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Course;
import com.design.machineManagement.pojo.res.RestFulBean;

import java.util.List;
import java.util.Map;

/**
 * (Course)表服务接口
 *
 * @author makejava
 * @since 2022-07-21 17:21:20
 */
public interface CourseService {

   //分页查询
    RestFulBean<Map> getList(Page<Course> page) throws Exception;

    RestFulBean<String> add(Course course);

    RestFulBean<String> update(Course course);

    RestFulBean<String> delete(Course course);


 RestFulBean<List<Course>> getAllList();
}
