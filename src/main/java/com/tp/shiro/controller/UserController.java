package com.tp.shiro.controller;

import com.tp.shiro.bean.User;
import com.tp.shiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/listAll")
    public List<User> listAll() {
        return userService.getAllUser();
    }

}
