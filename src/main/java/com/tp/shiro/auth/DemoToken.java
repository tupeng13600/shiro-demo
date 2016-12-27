package com.tp.shiro.auth;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
public class DemoToken implements AuthenticationToken {

    private DemoPrincipal principal;

    private String password;


    public Object getPrincipal() {
        return principal;
    }

    public Object getCredentials() {
        return password;
    }

    public DemoToken(DemoPrincipal principal, String password) {
        this.principal = principal;
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

}
