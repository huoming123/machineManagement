package com.design.machineManagement.controller;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Machine;
import com.design.machineManagement.pojo.ScheduleClass;
import com.design.machineManagement.pojo.res.RestFulBean;
import com.design.machineManagement.service.MachineService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * (Machine)表控制层
 *
 * @author makejava
 * @since 2022-07-25 09:09:10
 */
@RestController
@RequestMapping("/machine")
public class MachineController {
    /**
     * 服务对象
     */
    @Autowired
    private MachineService machineService;

    /**
     *  分页查询机房数据
     * @param
     * @return Map
     */
    @PostMapping("/get/list")
    public RestFulBean<Map> getList(@RequestBody Page<Machine> page) throws Exception {
        return machineService.getList(page);
    }
    //新增
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Machine machine) throws Exception {
        return machineService.insert(machine);
    }
    //修改
    @PostMapping("/update")
    public RestFulBean<String> update(@RequestBody  Machine machine) throws Exception {
        return machineService.update(machine);
    }
    //删除
    @PostMapping("/delete")
    public RestFulBean<String> delete(@RequestBody  Machine machine) throws Exception {
        return machineService.deleteById(machine.getId());
    }
    //获取所有机房
    @PostMapping("/get/all")
    public RestFulBean<List<Machine>> getAllList() throws Exception {
        return machineService.getAllList();
    }
}
