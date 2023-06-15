package com.design.machineManagement.mapper;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Machine;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Machine)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-25 09:09:10
 */
public interface MachineMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Machine queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询条件
     * @param limit   查询条数
     * @return 对象列表
     */
    List<Machine> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);

    /**
     * 统计总行数
     *
     * @param machine 查询条件
     * @return 总行数
     */
    long count(Machine machine);

    /**
     * 新增数据
     *
     * @param machine 实例对象
     * @return 影响行数
     */
    int insert(Machine machine);



    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Machine> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Machine> entities);

    /**
     * 修改数据
     *
     * @param machine 实例对象
     * @return 影响行数
     */
    int update(Machine machine);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

    List<Machine> getPageListByCondition( @Param("page") Page<Machine> page);

    Integer getPageListCount(@Param("page") Page<Machine> page);

    Machine getByRoomNo(String roomNo);

    List<Machine> getAllList();
}
