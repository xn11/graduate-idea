package com.cebbank.gage.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xn on 2017/3/15.
 */
@Entity
@Table(name = "gage_price")
public class Price {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "gage_id")
    private Gage gage;
    private double price;
    private String unit;    //单位

    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date timestamp;
    private String source;  //数据来源
    private String note;

    //constructor
    public Price() {
    }

    public Price(int id) {
        this.id = id;
    }

    public Price(Gage gage, double price, String unit, String source) {
        this.gage = gage;
        this.price = price;
        this.unit = unit;
        this.source = source;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Gage getGage() {
        return gage;
    }

    public void setGage(Gage gage) {
        this.gage = gage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
