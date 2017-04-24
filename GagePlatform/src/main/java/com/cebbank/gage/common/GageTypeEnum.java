package com.cebbank.gage.common;

import org.codehaus.jackson.annotate.JsonValue;

/**
 * Created by xn on 2017/3/6.
 * <p>
 * 其他0，金属矿产1、能源化工2、纺织品3、木材4、农产品5、汽车6
 */
public enum GageTypeEnum {

    OTHERS(0, "其他"),
    METAL_MINERALS(1, "金属矿产"),
    ENERGY_CHEMICAL_INDUSTRY(2, "能源化工"),
    TEXTILE(3, "纺织品"),
    WOOD(4, "木材"),
    FARM_PRODUCE(5, "农产品"),
    AUTOMOBILE(6, "汽车");

    private int id;
    private String name;

    private GageTypeEnum(int id, String name) {
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
