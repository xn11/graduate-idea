package com.cebbank.gage.common;

import org.codehaus.jackson.annotate.JsonValue;

/**
 * Created by xn on 2017/3/6.
 * <p>
 * 0未入库，1待审批，2已入库，3已结清出库，4未结清出库，5处置中，6已处置
 */
public enum ContractStatusTypeEnum {

    NOT_IN_STORAGE(0, "未入库"),
    APPROVAL_PENDING(1, "待审批"),
    IN_STORAGE(2, "已入库"),
    CLEAN_OUT(3, "已结清出库"),
    NOT_CLEAN_OUT(4, "未结清出库"),
    HANDLING(5, "处置中"),
    HANDLED(6, "已处置")
    ;

    private int id;
    private String name;

    private ContractStatusTypeEnum(int id, String name) {
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
