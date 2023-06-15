package com.design.machineManagement.controller;
import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Course;
import com.design.machineManagement.pojo.Users;
import com.design.machineManagement.pojo.res.RestFulBean;
import com.design.machineManagement.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2022-07-07 09:12:38
 */
@RestController
@RequestMapping("/users")
public class UsersController {
    /**
     * 服务对象
     */
    @Autowired
    private UsersService usersService;
    /**
     *  分页查询教师数据
     * @param
     * @return Map
     */
    @PostMapping("/get/list")
    public RestFulBean<Map> getList(@RequestBody Page<Users> page) throws Exception {
        return usersService.getList(page);
    }
    //新增
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Users users) throws Exception {
        return usersService.insert(users);
    }
    //修改
    @PostMapping("/update")
    public RestFulBean<String> update(@RequestBody Users users) throws Exception {
        return usersService.update(users);
    }
    //根据id删除
    @PostMapping("/delete")
    public RestFulBean<String> delete(@RequestBody Users users) throws Exception {
        return usersService.delete(users);
    }
    //根据id获取用户详情信息
    @PostMapping("/get/by/id")
    public RestFulBean<Users> getById(@RequestBody Users users) throws Exception {
        return usersService.getById(users);
    }
    //上传照片
    @PostMapping("/upload/image")
    public RestFulBean<Map> upload(@RequestParam(value = "coverFile",required = false) MultipartFile coverFile ) throws Exception  {
        return usersService.upload(coverFile);
    }
    //获取教师列表
    @PostMapping("/get/teachList")
    public RestFulBean<List<Users>> getTeachList() throws Exception {
        return usersService.getTeachList();
    }
    //获取管理员列表
    @PostMapping("/get/adminList")
    public RestFulBean<List<Users>> getAdminList() throws Exception {
        return usersService.getAdminList();
    }
}
