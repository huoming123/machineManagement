package com.design.machineManagement.mapper;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Course;
import com.design.machineManagement.pojo.ScheduleClass;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (ScheduleClass)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-23 13:35:04
 */
public interface ScheduleClassMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    ScheduleClass queryById(Integer id);



    /**
     * 统计总行数
     *
     * @param scheduleClass 查询条件
     * @return 总行数
     */
    long count(ScheduleClass scheduleClass);

    /**
     * 新增数据
     *
     * @param scheduleClass 实例对象
     * @return 影响行数
     */
    int insert(ScheduleClass scheduleClass);




    /**
     * 修改数据
     *
     * @param scheduleClass 实例对象
     * @return 影响行数
     */
    int update(ScheduleClass scheduleClass);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<ScheduleClass> getPageListByCondition(@Param("page")Page<ScheduleClass> page);

    Integer getPageListCount(@Param("page") Page<ScheduleClass> page);
}
