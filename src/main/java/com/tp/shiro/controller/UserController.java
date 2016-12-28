package com.tp.shiro.controller;

import com.tp.shiro.auth.DemoPrincipal;
import com.tp.shiro.bean.UserLoginInfo;
import com.tp.shiro.controller.model.UserModel;
import com.tp.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/login")
    public void login(@RequestBody UserModel userModel) {
        userService.login(userModel);
    }

    @PostMapping("/register")
    public void registration(@RequestBody UserModel userModel) {
        userService.register(userModel);
    }

    @GetMapping("/info")
    private String getCurrentUser() {
        DemoPrincipal principal = (DemoPrincipal) SecurityUtils.getSubject().getPrincipal();
        return principal.toString();
    }

    @GetMapping("/logs")
    private List<UserLoginInfo> getUserLogs() {
        return userService.getAllLogs();
    }

}
