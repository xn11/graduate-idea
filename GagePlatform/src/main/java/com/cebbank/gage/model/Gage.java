package com.cebbank.gage.model;

import com.cebbank.gage.common.GageTypeEnum;

import javax.persistence.*;

/**
 * Created by xn on 2017/3/15.
 */
@Entity
@Table
public class Gage {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private GageTypeEnum type;

    //最高质押率
    @Column(name = "max_pledge_rate")
    private double MaxPledgeRate;

    //警戒线
    @Column(name = "warning_line")
    private double warningLine;

    //处置线
    @Column(name = "dispose_line")
    private double disposeLine;

    private String note;

    //constructor
    public Gage() {
    }

    public Gage(int id) {
        this.id = id;
    }

    public Gage(String name, GageTypeEnum type, double maxPledgeRate, double warningLine, double disposeLine) {
        this.name = name;
        this.type = type;
        MaxPledgeRate = maxPledgeRate;
        this.warningLine = warningLine;
        this.disposeLine = disposeLine;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GageTypeEnum getType() {
        return type;
    }

    public void setType(GageTypeEnum type) {
        this.type = type;
    }

    public double getMaxPledgeRate() {
        return MaxPledgeRate;
    }

    public void setMaxPledgeRate(double maxPledgeRate) {
        MaxPledgeRate = maxPledgeRate;
    }

    public double getWarningLine() {
        return warningLine;
    }

    public void setWarningLine(double warningLine) {
        this.warningLine = warningLine;
    }

    public double getDisposeLine() {
        return disposeLine;
    }

    public void setDisposeLine(double disposeLine) {
        this.disposeLine = disposeLine;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
