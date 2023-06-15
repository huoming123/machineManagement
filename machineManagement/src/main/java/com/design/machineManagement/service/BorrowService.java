package com.design.machineManagement.service;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Borrow;
import com.design.machineManagement.pojo.res.RestFulBean;

import java.util.Map;

/**
 * (Borrow)表服务接口
 *
 * @author makejava
 * @since 2022-07-25 16:13:04
 */
public interface BorrowService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    RestFulBean<Borrow> queryById(Integer id);


    /**
     * 新增数据
     *
     * @param borrow 实例对象
     * @return 实例对象
     */
    RestFulBean<String> insert(Borrow borrow);

    /**
     * 修改数据
     *
     * @param borrow 实例对象
     * @return 实例对象
     */
   RestFulBean<String> update(Borrow borrow);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    RestFulBean<String> deleteById(Integer id);

    RestFulBean<Map> getList(Page<Borrow> page)throws Exception;

}
