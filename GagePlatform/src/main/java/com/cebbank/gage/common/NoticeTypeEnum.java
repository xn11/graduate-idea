package com.cebbank.gage.common;

import org.codehaus.jackson.annotate.JsonValue;

/**
 * Created by xn on 2017/3/6.
 * <p>
 * 出质通知书、结清通知书、质押物变更通知书、提货通知书、比对错误通知书
 */
public enum NoticeTypeEnum {

    PLEDGE_START(0, "出质通知书"),
    PLEDGE_END(1, "结清通知书"),
    PLEDGE_CHANGE(2, "质押物变更通知书"),
    PLEDGE_DELIVERY(3, "提货通知书"),
    MATCH_ERROR(4, "比对错误通知书");

    private int id;
    private String name;

    private NoticeTypeEnum(int id, String name) {
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
