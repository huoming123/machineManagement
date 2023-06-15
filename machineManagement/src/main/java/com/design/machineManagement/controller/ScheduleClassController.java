package com.design.machineManagement.controller;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Course;
import com.design.machineManagement.pojo.ScheduleClass;
import com.design.machineManagement.pojo.Users;
import com.design.machineManagement.pojo.res.RestFulBean;
import com.design.machineManagement.service.ScheduleClassService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * (ScheduleClass)表控制层
 *
 * @author makejava
 * @since 2022-07-23 13:35:04
 */
@RestController
@RequestMapping("/scheduleClass")
public class ScheduleClassController {
    /**
     * 服务对象
     */
    @Autowired
    private ScheduleClassService scheduleClassService;


    //新增
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody ScheduleClass scheduleClass) throws Exception {
        return scheduleClassService.insert(scheduleClass);
    }
    //修改
    @PostMapping("/update")
    public RestFulBean<String> update(@RequestBody ScheduleClass scheduleClass) throws Exception {
        return scheduleClassService.update(scheduleClass);
    }
    //删除
    @PostMapping("/delete")
    public RestFulBean<String> delete(@RequestBody ScheduleClass scheduleClass) throws Exception {
        return scheduleClassService.deleteById(scheduleClass.getId());
    }
    /**
     *  分页查询课程数据
     * @param
     * @return Map
     */
    @PostMapping("/get/scheduleClass/list")
    public RestFulBean<Map> getList(@RequestBody Page<ScheduleClass> page) throws Exception {
        return scheduleClassService.getList(page);
    }
}
