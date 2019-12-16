package com.xxm.wanandroid.model;

public class BaseModel {
    private int errorCode;  //0 代表执行成功，不建议依赖任何非0的 errorCode. -1001 代表登录失效，需要重新登录。
    private String errorMsg;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }


    @Override
    public String toString() {
        return "BaseModel{" +
                "errorCode=" + errorCode +
                ", errorMsg='" + errorMsg + '\'' +
                '}';
    }
}
