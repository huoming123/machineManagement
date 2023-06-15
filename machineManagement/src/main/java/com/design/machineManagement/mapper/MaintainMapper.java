package com.design.machineManagement.mapper;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Maintain;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Maintain)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-26 14:47:58
 */
public interface MaintainMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Maintain queryById(Integer id);


    /**
     * 新增数据
     *
     * @param maintain 实例对象
     * @return 影响行数
     */
    int insert(Maintain maintain);


    /**
     * 修改数据
     *
     * @param maintain 实例对象
     * @return 影响行数
     */
    int update(Maintain maintain);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Maintain> getPageListByCondition(@Param("page")Page<Maintain> page);

    Integer getPageListCount(@Param("page")Page<Maintain> page);

    Maintain getByOrderId(String orderId);

    Maintain queryByRoomNoAndcomputerNo(Maintain maintain);

    List<Maintain> getPageCountListByCondition(@Param("page")Page<Maintain> page);
}
