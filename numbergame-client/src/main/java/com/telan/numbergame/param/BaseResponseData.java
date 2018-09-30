package com.telan.numbergame.param;


/**
 * Created by weiwenliang on 17/8/22.
 */
public class BaseResponseData {
    private int status;

    private int code;

    private String msg;


    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

}


