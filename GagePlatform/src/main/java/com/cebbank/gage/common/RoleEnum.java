package com.cebbank.gage.common;

import org.codehaus.jackson.annotate.JsonValue;

/**
 * Created by xn on 2017/3/6.
 *
 * 用户角色Role(name, id)
 */
public enum RoleEnum {
    ADMIN("系统管理员", 0),
    ACCOUNT_MANAGER("客户经理", 1),
    MARKETING_DIRECTOR("公司部主任", 2),
    REGULATORS("监管机构", 3),
    REGULATOR("监管员", 4),
    CREDIT_EXECUTION("授信执行人", 5),
    CREDIT_EXECUTION_DIRECTOR("授信执行主任", 6);

    private String name;
    private int id;

    private RoleEnum(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }
}
