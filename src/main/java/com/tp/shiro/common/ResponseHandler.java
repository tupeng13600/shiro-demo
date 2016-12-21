package com.tp.shiro.common;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
@ControllerAdvice
public class ResponseHandler implements ResponseBodyAdvice<Object> {

    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (body instanceof RespModel || !mediaType.includes(MediaType.APPLICATION_JSON)) {
            return body;
        }
        RespModel respModel = new RespModel(true, "请求成功");
        respModel.setData(body);
        return respModel;
    }
}
