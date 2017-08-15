package com.tp.shiro.controller;

import com.tp.shiro.auth.DemoPrincipal;
import com.tp.shiro.bean.UserLoginInfo;
import com.tp.shiro.controller.doc.UserControllerDoc;
import com.tp.shiro.controller.model.UserModel;
import com.tp.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
@RestController
public class UserController implements UserControllerDoc {

    @Autowired
    private UserService userService;

    public void login(@RequestBody UserModel userModel) {
        userService.login(userModel);
    }

    public void registration(@RequestBody UserModel userModel) {
        userService.register(userModel);
    }

    public DemoPrincipal getCurrentUser() {
        return (DemoPrincipal) SecurityUtils.getSubject().getPrincipal();
    }

    public List<UserLoginInfo> getUserLogs() {
        return userService.getAllLogs();
    }

}
