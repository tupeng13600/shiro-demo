package com.tp.shiro.common;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
public class RespModel {

    private boolean status;

    private String description;

    private Object data;

    public RespModel(boolean status, String description) {
        this.status = status;
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
