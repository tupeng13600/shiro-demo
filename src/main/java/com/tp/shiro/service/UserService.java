package com.tp.shiro.service;

import com.tp.shiro.auth.DemoToken;
import com.tp.shiro.bean.User;
import com.tp.shiro.controller.model.UserModel;
import com.tp.shiro.mapper.UserMapper;
import com.tp.shiro.util.SecurityUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
@Service
public class UserService {

    private Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    public User getByUsername(String username) {
        return userMapper.getByUsername(username);
    }

    public void login(UserModel model) {
        SecurityUtils.getSubject().login(new DemoToken(model.getUsername(), model.getPassword()));
    }

    public void register(UserModel userModel) {
        User user = getByUsername(userModel.getUsername());
        if (null != user) {
            throw new RuntimeException();
        }
        user = new User();
        user.setUsername(userModel.getUsername());
        String salt = SecurityUtil.randomString();
        user.setPassword(SecurityUtil.encryptPwd(userModel.getPassword(), new SimpleByteSource(salt)));
        user.setSalt(salt);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userMapper.create(user);
    }

}
