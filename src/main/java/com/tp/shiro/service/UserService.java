package com.tp.shiro.service;

import com.tp.shiro.auth.DemoPrincipal;
import com.tp.shiro.auth.DemoToken;
import com.tp.shiro.bean.User;
import com.tp.shiro.bean.UserLoginInfo;
import com.tp.shiro.controller.model.UserModel;
import com.tp.shiro.exception.DemoException;
import com.tp.shiro.mapper.UserMapper;
import com.tp.shiro.mongo.MongoOperation;
import com.tp.shiro.util.SecurityUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

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

    @Transactional
    public void login(UserModel model) {
        User user = userMapper.getByUsername(model.getUsername());
        if (null == user) {
            throw new DemoException("用户不存在");
        }
        //使用mongodb记录日志:仅仅是为了测试mongodb的使用
//        super.save(new UserLoginInfo(user.getId(), user.getUsername(), new Date()));
        SecurityUtils.getSubject().login(new DemoToken(new DemoPrincipal(user.getId(), user.getUsername()), model.getPassword()));
    }

    @Transactional
    public void register(UserModel userModel) {
        User user = getByUsername(userModel.getUsername());
        if (null != user) {
            throw new DemoException("用户名已存在");
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

    /**
     * 获取登录日志
     *
     * @return
     */
    public List<UserLoginInfo> getAllLogs() {
//        return super.listAll(UserLoginInfo.class);
        return null;
    }


}
