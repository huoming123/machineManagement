package com.design.machineManagement.service;

import com.design.machineManagement.dto.Page;
import com.design.machineManagement.pojo.Users;
import com.design.machineManagement.pojo.res.RestFulBean;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

/**
 * (Users)表服务接口
 *
 * @author makejava
 * @since 2022-07-07 09:12:43
 */
public interface UsersService {


    RestFulBean<Map<String, Object>> login(Users users);

    RestFulBean<Map> getList(Page<Users> page) throws  Exception;

    RestFulBean<String> insert(Users users);

    RestFulBean<String> update(Users users);

    RestFulBean<String> delete(Users users);

    RestFulBean<Users> getById(Users users);

    RestFulBean<Map> upload(MultipartFile coverFile);

    RestFulBean<List<Users>> getTeachList();

    RestFulBean<List<Users>> getAdminList();
}
