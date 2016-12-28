package com.tp.shiro.mongo;

/**
 * Created by Tupeng <tupeng@gengee.cn>
 */
public class OperationArg {

    private String argName;

    private Object argValue;

    public OperationArg(String argName, Object argValue) {
        this.argName = argName;
        this.argValue = argValue;
    }

    public String getArgName() {
        return argName;
    }

    public void setArgName(String argName) {
        this.argName = argName;
    }

    public Object getArgValue() {
        return argValue;
    }

    public void setArgValue(Object argValue) {
        this.argValue = argValue;
    }

}
