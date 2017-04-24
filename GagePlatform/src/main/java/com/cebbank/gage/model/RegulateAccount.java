package com.cebbank.gage.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xn on 2017/3/15.
 * <p>
 * 台账
 */
@Entity
@Table(name = "regulate_account")
public class RegulateAccount {
    @Id
    @GeneratedValue
    private int id;

//    @ManyToOne(cascade = {CascadeType.MERGE})
//    @JoinColumn(name = "regulator_id")
//    private RegulatorsCompany regulator;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "gage_id")
    private Gage gage;

    //出入货数量(正负)
    private double quantity;

    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date timestamp;
    private String note;

    //constructor
    public RegulateAccount() {
    }

    public RegulateAccount(int id) {
        this.id = id;
    }

    public RegulateAccount(Company company, Gage gage, double quantity) {
        this.company = company;
        this.gage = gage;
        this.quantity = quantity;
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

    public Gage getGage() {
        return gage;
    }

    public void setGage(Gage gage) {
        this.gage = gage;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
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
