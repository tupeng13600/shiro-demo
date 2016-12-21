package com.tp.shiro.mapper;

import com.tp.shiro.bean.User;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
public interface UserMapper {

    void create(User user);

    User getByUsername(String username);

}
