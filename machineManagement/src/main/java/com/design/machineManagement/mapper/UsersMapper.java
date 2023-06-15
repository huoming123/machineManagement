package com.design.machineManagement.mapper;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Course;
import com.design.machineManagement.pojo.Users;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (Users)表数据库访问层
 *
 * @author makejava
 * @since 2022-07-07 09:12:44
 */
public interface UsersMapper {



    Users getById(Integer id);


    Users getByTeachNoAndRole(@Param("teachNo")Integer teachNo, @Param("role")String role);

    List<Users> getPageListByCondition( @Param("page") Page<Users> page);

    Integer getPageListCount(@Param("page") Page<Users> page);

    void insert(Users users);

    void update(Users users);

    void deleteById(Integer id);

    List<Users> getTeachList();


    List<Users> getAdminList();

    Users getByTeachNo(Integer teachNo);
}
