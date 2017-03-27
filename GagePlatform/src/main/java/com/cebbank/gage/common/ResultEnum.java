package com.cebbank.gage.common;

/**
 * Created by xn on 2017/3/27.
 */
public enum ResultEnum {
    NORMAL(0, "正常"),
    E_DATABASE_GET(1, "数据库获取错误"),
    E_DATABASE_INSERT(2, "数据库插入错误"),
    E_DATABASE_UPDATE(3, "数据库更新错误"),
    E_DATABASE_DELETE(4, "数据库删除错误"),
    E_INVALID_PARAMETER(5, "无效参数"),
    E_NOT_EXIST(6, "数据不存在"),
    E_PASSWORD_WRONG(7, "密码错误");

    private int code;
    private String desc;

    private ResultEnum(int code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
