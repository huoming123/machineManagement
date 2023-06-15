package com.design.machineManagement.service;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Machine;
import com.design.machineManagement.pojo.res.RestFulBean;

import java.util.List;
import java.util.Map;

/**
 * (Machine)表服务接口
 *
 * @author makejava
 * @since 2022-07-25 09:09:10
 */
public interface MachineService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Machine> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param machine 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Machine machine);

    /**
     * 修改数据
     *
     * @param machine 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Machine machine);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map> getList(Page<Machine> page) throws Exception;

    RestFulBean<List<Machine>> getAllList();
}
