package com.tp.shiro.listener;

import com.tp.shiro.auth.DemoPrincipal;
import com.tp.shiro.auth.DemoToken;
import org.apache.http.client.utils.DateUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationListener;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Date;

/**
 * Created by tupeng on 2017/7/18.
 */
public class DemoListener implements AuthenticationListener {

    private Logger logger = LogManager.getLogger(this.getClass());

    @Override
    public void onSuccess(AuthenticationToken token, AuthenticationInfo info) {
        DemoPrincipal principal = (DemoPrincipal) info.getPrincipals().getPrimaryPrincipal();
        logger.info("user:{} is login, time is:{}", principal, DateUtils.formatDate(new Date(), "yyyy-MM-dd HH:mm:ss"));
    }

    @Override
    public void onFailure(AuthenticationToken token, AuthenticationException ae) {
        DemoToken demoToken = (DemoToken) token;
        logger.error("user:{} is login fail, the exception is:{}", demoToken.getPrincipal(), ae);
    }

    @Override
    public void onLogout(PrincipalCollection principals) {
        DemoPrincipal principal = (DemoPrincipal) principals.getPrimaryPrincipal();
        logger.info("user:{} is logout", principal);
    }
}
