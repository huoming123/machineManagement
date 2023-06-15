package com.design.machineManagement.controller;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Borrow;
import com.design.machineManagement.pojo.Maintain;
import com.design.machineManagement.pojo.res.RestFulBean;
import com.design.machineManagement.service.MaintainService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * (Maintain)表控制层
 *
 * @author makejava
 * @since 2022-07-26 14:47:58
 */
@RestController
@RequestMapping("/maintain")
public class MaintainController {
    /**
     * 服务对象
     */
    @Autowired
    private MaintainService maintainService;

    /**
     *
     *
     * @param
     * @return  维修工单列表
     */
    @PostMapping("/get/list")
    public RestFulBean<Map> getList(@RequestBody Page<Maintain> page)throws Exception {
        return this.maintainService.getList(page);
    }
    /**
     *
     *
     * @param
     * @return  维修工单统计
     */
    @PostMapping("/get/list/count")
    public RestFulBean<Map> getListCount(@RequestBody Page<Maintain> page)throws Exception {
        return this.maintainService.getListCount(page);
    }
    /**
     *
     *
     * @param
     * @return  新增
     */
    @PostMapping("/add")
    public RestFulBean<String> getList(@RequestBody Maintain maintain)throws Exception {
        return this.maintainService.insert(maintain);
    }
    /**
     *
     *
     * @param
     * @return  修改
     */
    @PostMapping("/update")
    public RestFulBean<String> update(@RequestBody Maintain maintain)throws Exception {
        return this.maintainService.update(maintain);
    }
    /**
     *
     *
     * @param
     * @return  删除
     */
    @PostMapping("/delete")
    public RestFulBean<String> delete(@RequestBody Maintain maintain)throws Exception {
        return this.maintainService.deleteById(maintain.getId());
    }
}
