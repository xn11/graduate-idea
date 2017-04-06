package com.cebbank.gage.common;

import org.codehaus.jackson.annotate.JsonValue;

/**
 * Created by xn on 2017/3/6.
 * <p>
 * 用户角色Role(name, id)
 */
public enum StatusTypeEnum {

    UNPROCESSED(0, "未处理"),
    IN_PROCESS(1, "处理中"),
    PROCESSED(2, "已处理"),
    CANCELLED(3, "已取消");

    private int id;
    private String name;

    private StatusTypeEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
