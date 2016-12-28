package com.tp.shiro.bean;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
@Document(collection = "login_info")
public class UserLoginInfo {

    private Long userId;

    private String username;

    private Date loginTime;

    public UserLoginInfo(Long userId, String username, Date loginTime) {
        this.userId = userId;
        this.username = username;
        this.loginTime = loginTime;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }
}
