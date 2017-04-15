package com.cebbank.gage.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xn on 2017/3/15.
 */
@Entity
@Table(name = "bidding_regulators")
public class BiddingRegulators {
    @Id
    @GeneratedValue
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "bidding_id")
    private Bidding bidding;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "regulators_id")
    private Regulators regulators;

    private double fee;

    //未出价0、等待结果1、中标2、未中标3、无效-1
    private int status;

    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date timestamp;
    private String note;

    //constructor
    public BiddingRegulators() {
    }

    public BiddingRegulators(int id) {
        this.id = id;
    }

    public BiddingRegulators(Bidding bidding, Regulators regulators) {
        this.bidding = bidding;
        this.regulators = regulators;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Bidding getBidding() {
        return bidding;
    }

    public void setBidding(Bidding bidding) {
        this.bidding = bidding;
    }

    public Regulators getRegulators() {
        return regulators;
    }

    public void setRegulators(Regulators regulators) {
        this.regulators = regulators;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
