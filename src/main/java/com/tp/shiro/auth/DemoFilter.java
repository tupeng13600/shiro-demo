package com.tp.shiro.auth;

import com.google.gson.Gson;
import com.tp.shiro.common.RespModel;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;
import org.springframework.http.MediaType;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
public class DemoFilter extends BasicHttpAuthenticationFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return super.isAccessAllowed(request, response, mappedValue);
    }

    /**
     * 重写请求被拒绝时的处理方式
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        RespModel respModel = new RespModel(false);
        respModel.setData("未授权，或授权失败");
        String json = new Gson().toJson(respModel);
        httpResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpResponse.getWriter().write(json);
        return super.onAccessDenied(request,response);
    }

}
