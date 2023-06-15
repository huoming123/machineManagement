package com.design.machineManagement.mapper;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Borrow;
import com.design.machineManagement.pojo.Machine;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Borrow)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-25 16:13:04
 */
public interface BorrowMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Borrow queryById(Integer id);


    /**
     * 新增数据
     *
     * @param borrow 实例对象
     * @return 影响行数
     */
    int insert(Borrow borrow);


    /**
     * 修改数据
     *
     * @param borrow 实例对象
     * @return 影响行数
     */
    int update(Borrow borrow);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Borrow> getPageListByCondition(@Param("page") Page<Borrow> page);

    Integer getPageListCount(@Param("page") Page<Borrow> page);

    List<Borrow> getByTime(Borrow borrow);

    List<Borrow> getByUserId(Borrow borrow);
}
