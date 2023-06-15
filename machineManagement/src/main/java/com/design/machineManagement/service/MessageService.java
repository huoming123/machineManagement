package com.design.machineManagement.service;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Message;
import com.design.machineManagement.pojo.res.RestFulBean;

import java.util.List;
import java.util.Map;

/**
 * (Message)表服务接口
 *
 * @author makejava
 * @since 2022-09-01 14:59:31
 */
public interface MessageService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Message> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Message message);

    /**
     * 修改数据
     *
     * @param message 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Message message);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map> getList(Page<Message> page) throws Exception;

    RestFulBean<List<Message>> getMessage();
}
