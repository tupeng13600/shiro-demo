package com.tp.shiro.auth;

import com.tp.shiro.bean.User;
import com.tp.shiro.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.SimpleByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
public class DemoRealm extends AuthorizingRealm {

    @Autowired
    private UserService userService;

    private Logger logger = LogManager.getLogger(this.getClass());

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        DemoPrincipal principal = (DemoPrincipal) authenticationToken.getPrincipal();
        User user = userService.getByUsername(principal.getUsername());
        if (null == user) {
            logger.error("登录失败，用户不存在!!");
            throw new UnknownAccountException("用户不存在");
        }
        return new SimpleAuthenticationInfo(principal, user.getPassword(), new SimpleByteSource(user.getSalt()), getName());
    }

    /**
     * 授权
     *
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return new SimpleAuthorizationInfo();
    }

    /**
     * 支持校验的token类型
     *
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof DemoToken;
    }
}
