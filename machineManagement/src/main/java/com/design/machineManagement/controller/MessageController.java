package com.design.machineManagement.controller;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Course;
import com.design.machineManagement.pojo.Maintain;
import com.design.machineManagement.pojo.Message;
import com.design.machineManagement.service.MessageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import com.design.machineManagement.pojo.res.RestFulBean;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

/**
 * (Message)表控制层
 *
 * @author makejava
 * @since 2022-09-01 14:59:31
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    /**
     * 服务对象
     */
    @Autowired
    private MessageService messageService;

    /**
     *  分页查询
     * @param
     * @return Map
     */
    @PostMapping("/get/message/list")
    public RestFulBean<Map> getList(@RequestBody Page<Message> page) throws Exception {
        return messageService.getList(page);
    }
    /**
     *  获取最新通告
     * @param
     * @return Map
     */
    @PostMapping("/get/message")
    public RestFulBean<List<Message>> getMessage() throws Exception {
        return messageService.getMessage();
    }

    /**
     *
     *
     * @param
     * @return  新增
     */
    @PostMapping("/add")
    public RestFulBean<String> getList(@RequestBody Message message)throws Exception {
        return this.messageService.insert(message);
    }
    /**
     *
     *
     * @param
     * @return  修改
     */
    @PostMapping("/update")
    public RestFulBean<String> update(@RequestBody Message message)throws Exception {
        return this.messageService.update(message);
    }
    /**
     *
     *
     * @param
     * @return  删除
     */
    @PostMapping("/delete")
    public RestFulBean<String> delete(@RequestBody Message message)throws Exception {
        return this.messageService.deleteById(message.getId());
    }
}
