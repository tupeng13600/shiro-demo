package com.tp.shiro.exception;

import com.tp.shiro.common.RespModel;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
@ControllerAdvice
public class DemoExceptionHandler {

    private Logger logger = LogManager.getLogger(this.getClass());

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RespModel all(Exception e) {
        logger.debug("Exception:", e);
        return new RespModel(false).setData("系统错误，请联系相关管理人员");
    }

    @ExceptionHandler(DemoException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public RespModel demo(DemoException e) {
        return new RespModel(false).setData(e.getMessage());
    }

}
