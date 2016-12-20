package com.tp.shiro.service;

import com.tp.shiro.bean.User;
import com.tp.shiro.mapper.UserMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
@Service
public class UserService {

    private Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    public List<User> getAllUser(){
        List<User> users =  userMapper.getAllUser();
        logger.info("----------------------------------------------");
        return users;
    }

}
