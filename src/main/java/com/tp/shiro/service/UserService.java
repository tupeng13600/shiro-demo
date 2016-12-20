package com.tp.shiro.service;

import com.tp.shiro.bean.User;
import com.tp.shiro.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUser(){
        return userMapper.getAllUser();
    }

}
