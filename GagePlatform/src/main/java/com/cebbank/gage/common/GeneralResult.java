package com.cebbank.gage.common;

/**
 * Created by xn on 2017/3/27.
 */
public class GeneralResult<T> {
    private ResultEnum resultCode = ResultEnum.NORMAL;
    ;
    private String message;
    private T data;

    public GeneralResult() {
    }

    public GeneralResult(ResultEnum resultCode) {
        this.resultCode = resultCode;
    }

    public GeneralResult(ResultEnum resultCode, T data) {
        this.resultCode = resultCode;
        this.data = data;
    }

    public ResultEnum getResultCode() {
        return resultCode;
    }

    public void setResultCode(ResultEnum resultCode) {
        this.resultCode = resultCode;
    }

    public String getMessage() {
        String msg = message == null ? "" : message;
        return resultCode + "！ " + msg;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isNormal() {
        return resultCode == ResultEnum.NORMAL;
    }

}
