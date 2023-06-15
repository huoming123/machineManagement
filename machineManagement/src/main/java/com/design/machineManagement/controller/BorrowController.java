package com.design.machineManagement.controller;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Borrow;
import com.design.machineManagement.pojo.Machine;
import com.design.machineManagement.pojo.Submenu;
import com.design.machineManagement.pojo.res.RestFulBean;
import com.design.machineManagement.service.BorrowService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

/**
 * (Borrow)表控制层
 *
 * @author makejava
 * @since 2022-07-25 16:13:04
 */
@RestController
@RequestMapping("/borrow")
public class BorrowController {
    /**
     * 服务对象
     */
    @Autowired
    private BorrowService borrowService;

    /**
     * 新增数据
     *
     * @param
     * @return 新增结果
     */
    @PostMapping("/add")
    public RestFulBean<String> add(@RequestBody Borrow borrow) {
        return this.borrowService.insert(borrow);
    }
    /**
     *
     *
     * @param
     * @return  机房借出列表
     */
    @PostMapping("/get/list")
    public RestFulBean<Map> getList(@RequestBody Page<Borrow> page)throws Exception {
        return this.borrowService.getList(page);
    }

    @PostMapping("/update")
    public RestFulBean<String> update(@RequestBody Borrow borrow)throws Exception {
        return this.borrowService.update(borrow);
    }
}
