package com.design.machineManagement.controller;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Course;
import com.design.machineManagement.pojo.Users;
import com.design.machineManagement.pojo.res.RestFulBean;
import com.design.machineManagement.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * (Course)表控制层
 *
 * @author makejava
 * @since 2022-07-21 17:21:20
 */
@RestController
@RequestMapping("/course")
public class CourseController {
    /**
     * 服务对象
     */
    @Autowired
    private CourseService courseService;

    /**
     *  分页查询课程数据
     * @param
     * @return Map
     */
    @PostMapping("/get/course/list")
    public RestFulBean<Map> getList(@RequestBody Page<Course> page) throws Exception {
        return courseService.getList(page);
    }
    /**
     *  新增
     * @param
     * @return Map
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Course course) throws Exception {
        return courseService.add(course);
    }
    /**
     *  修改
     * @param
     * @return Map
     */
    @PostMapping("/update")
    public RestFulBean<String> update(@RequestBody Course course) throws Exception {
        return courseService.update(course);
    }
    /**
     *  删除
     * @param
     * @return Map
     */
    @PostMapping("/delete")
    public RestFulBean<String> delete(@RequestBody Course course) throws Exception {
        return courseService.delete(course);
    }

    @PostMapping("/get/all/list")
    public RestFulBean<List<Course>> getAllList() throws Exception {
        return courseService.getAllList();
    }
}
