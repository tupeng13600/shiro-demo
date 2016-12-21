package com.tp.shiro.common;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
public class RespModel {

    private boolean status;

    private String description;

    private Object data;

    public RespModel(Boolean status) {
        this.status = status;
        if (status) {
            this.description = "请求成功";
        } else {
            this.description = "请求失败";
        }
    }

    public boolean isStatus() {
        return status;
    }

    public RespModel setStatus(boolean status) {
        this.status = status;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public RespModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Object getData() {
        return data;
    }

    public RespModel setData(Object data) {
        this.data = data;
        return this;
    }
}
