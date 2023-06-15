package com.design.machineManagement.mapper;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Message;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Message)表数据库访问层
 *
 * @author makejava
 * @since 2022-09-01 14:59:31
 */
public interface MessageMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Message queryById(Integer id);


    /**
     * 新增数据
     *
     * @param message 实例对象
     * @return 影响行数
     */
    int insert(Message message);


    /**
     * 修改数据
     *
     * @param message 实例对象
     * @return 影响行数
     */
    int update(Message message);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Message> getPageListByCondition(@Param("page") Page<Message> page);

    Integer getPageListCount(@Param("page")Page<Message> page);

    List<Message> getMessage();
}
