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
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "bidding_id")
    private Bidding bidding;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "regulators_id")
    private Regulators regulators;

    private double fee;

    //未出价、等待结果、中标、未中标、无效
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
