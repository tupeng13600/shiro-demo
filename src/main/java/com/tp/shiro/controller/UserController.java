package com.tp.shiro.controller;

import com.tp.shiro.auth.DemoPrincipal;
import com.tp.shiro.bean.UserLoginInfo;
import com.tp.shiro.common.DemoResponse;
import com.tp.shiro.controller.model.UserModel;
import com.tp.shiro.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
@RestController
@RequestMapping("/user")
@Api(value = "USER", description = "用户控制器入口")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "登录", notes = "用户通过账号和密码登录系统", httpMethod = "PUT", produces = MediaType.APPLICATION_JSON_VALUE)
    @PutMapping("/login")
    @DemoResponse
    public void login(@RequestBody UserModel userModel) {
        userService.login(userModel);
    }

    @PostMapping("/register")
    @DemoResponse
    public void registration(@RequestBody UserModel userModel) {
        userService.register(userModel);
    }

    @GetMapping("/info")
    @DemoResponse
    private String getCurrentUser() {
        DemoPrincipal principal = (DemoPrincipal) SecurityUtils.getSubject().getPrincipal();
        return principal.toString();
    }

    @GetMapping("/logs")
    @DemoResponse
    private List<UserLoginInfo> getUserLogs() {
        return userService.getAllLogs();
    }

}
