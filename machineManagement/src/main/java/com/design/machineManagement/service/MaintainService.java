package com.design.machineManagement.service;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Maintain;
import com.design.machineManagement.pojo.res.RestFulBean;

import java.util.Map;

/**
 * (Maintain)表服务接口
 *
 * @author makejava
 * @since 2022-07-26 14:47:58
 */
public interface MaintainService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Maintain> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param maintain 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Maintain maintain);

    /**
     * 修改数据
     *
     * @param maintain 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Maintain maintain);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map> getList(Page<Maintain> page) throws Exception;

    RestFulBean<Map> getListCount(Page<Maintain> page) throws Exception;
}
