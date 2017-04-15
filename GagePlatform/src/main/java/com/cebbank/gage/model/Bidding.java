package com.cebbank.gage.model;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xn on 2017/4/15.
 */
@Entity
@Table
public class Bidding {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "regulators_id")
    private Regulators regulators;

    private double fee;

    //竞价中、已结束、无效
    private int status;

    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date timestamp;

    private String note;

    //外键关联属性
//    @JsonIgnore
    @OneToMany(mappedBy = "bidding", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Set<BiddingRegulators> regulatorses = new HashSet<BiddingRegulators>();

    //constructor
    public Bidding() {
    }

    public Bidding(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
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

    public Set<BiddingRegulators> getRegulatorses() {
        return regulatorses;
    }

    public void setRegulatorses(Set<BiddingRegulators> regulatorses) {
        this.regulatorses = regulatorses;
    }
}
