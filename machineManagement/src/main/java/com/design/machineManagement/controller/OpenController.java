package com.design.machineManagement.controller;
import com.design.machineManagement.pojo.Users;
import com.design.machineManagement.pojo.res.RestFulBean;
import com.design.machineManagement.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class OpenController {

    @Autowired
    private UsersService userService;
    /**
     *
     * @param Users 需要teachNo和password
     * @return data token
     */
    @PostMapping("/login")
    public RestFulBean<Map<String,Object>> login(@RequestBody Users Users) throws Exception {
        return userService.login(Users);
    }

}

