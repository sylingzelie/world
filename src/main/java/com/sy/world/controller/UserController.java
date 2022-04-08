package com.sy.world.controller;

import com.sy.world.entity.Staff;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "用户管理", tags = "用户管理")
@RestController
@RequestMapping("user")
public class UserController {


    @ApiOperation("获取用户")
    @GetMapping("getStaff")
    public Staff getUser() {
        Staff staff = new Staff();
        return staff;
    }
}
