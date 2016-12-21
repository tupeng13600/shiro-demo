package com.tp.shiro.auth;

import com.tp.shiro.util.SecurityUtil;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.CredentialsMatcher;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
public class DemoCredentialsMatcher implements CredentialsMatcher {

    public boolean doCredentialsMatch(AuthenticationToken token, AuthenticationInfo info) {
        SimpleAuthenticationInfo simpleInfo = (SimpleAuthenticationInfo) info;
        String desPwd = SecurityUtil.encryptPwd((String) token.getCredentials(), simpleInfo.getCredentialsSalt());
        if (desPwd.equals(info.getCredentials())) {
            return true;
        }
        return false;
    }
}
