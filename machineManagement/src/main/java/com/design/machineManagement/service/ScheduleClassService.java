package com.design.machineManagement.service;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.ScheduleClass;
import com.design.machineManagement.pojo.res.RestFulBean;

import java.util.Map;

/**
 * (ScheduleClass)表服务接口
 *
 * @author makejava
 * @since 2022-07-23 13:35:04
 */
public interface ScheduleClassService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<ScheduleClass> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param scheduleClass 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(ScheduleClass scheduleClass);

    /**
     * 修改数据
     *
     * @param scheduleClass 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(ScheduleClass scheduleClass);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map> getList(Page<ScheduleClass> page)throws Exception;
}
