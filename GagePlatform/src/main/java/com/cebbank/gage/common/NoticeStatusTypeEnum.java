package com.cebbank.gage.common;

import org.codehaus.jackson.annotate.JsonValue;

/**
 * Created by xn on 2017/3/6.
 * <p>
 * 待审批、退回、竞价中；线下处理中；待确认、已确认（上传仓单）
 */
public enum NoticeStatusTypeEnum {

    APPROVAL_PENDING(0, "待审批"),
    SEND_BACK(1, "退回"),
    IN_BIIDING(2, "竞价中"),
    OFFLINE(3, "线下处理中"),
    CONFIRM_PENDING(4, "待确认"),
    CONFIRMED(5, "已确认"),
    ;

    private int id;
    private String name;

    private NoticeStatusTypeEnum(int id, String name) {
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
