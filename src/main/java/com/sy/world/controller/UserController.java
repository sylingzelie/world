package com.sy.world.controller;

import com.sy.world.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户管理",tags = "用户管理")
@RestController
public class UserController {


    @ApiOperation("获取用户")
    @GetMapping("getUser")
    public User getUser(){
        User user = new User();
        user.setUsername("sy-612222111");
        return user;
    }
}
