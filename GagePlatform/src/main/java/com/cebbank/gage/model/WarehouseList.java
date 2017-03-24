package com.cebbank.gage.model;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xn on 2017/3/15.
 */
@Entity
@Table(name = "warehouse_list")
public class WarehouseList {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "gage_id")
    private Gage gage;

    private double quantity;
    private String specification;   //规格
    private int owner;  //权属

    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date timestamp;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "submitter_id")
    private User submitter;     //监管员或者客户经理，如null则为系统自动生成

    private String note;

    //constructor
    public WarehouseList() {
    }

    public WarehouseList(int id) {
        this.id = id;
    }

    public WarehouseList(Company company, Gage gage, double quantity, User submitter) {
        this.company = company;
        this.gage = gage;
        this.quantity = quantity;
        this.submitter = submitter;
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

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public User getSubmitter() {
        return submitter;
    }

    public void setSubmitter(User submitter) {
        this.submitter = submitter;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
