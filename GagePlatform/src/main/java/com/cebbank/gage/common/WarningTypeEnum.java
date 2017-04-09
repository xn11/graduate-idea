package com.cebbank.gage.common;

import org.codehaus.jackson.annotate.JsonValue;

/**
 * Created by xn on 2017/3/6.
 * <p>
 * 用户角色Role(name, id)
 */
public enum WarningTypeEnum {
    OTHER_WARNING(0, "其他预警"),
    QUANTITY_WARNING(1, "数量预警"),
    VALUE_WARNING(2, "价值预警"),
    REGULATE_WARNING(3, "监管预警");

    private int id;
    private String name;

    private WarningTypeEnum(int id, String name) {
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
