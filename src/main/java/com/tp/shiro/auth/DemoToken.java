package com.tp.shiro.auth;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.util.SimpleByteSource;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
public class DemoToken implements AuthenticationToken {

    private String username;

    private String password;


    public Object getPrincipal() {
        return username;
    }

    public Object getCredentials() {
        return password;
    }

    public DemoToken(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
