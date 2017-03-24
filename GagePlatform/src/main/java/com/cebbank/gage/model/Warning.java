package com.cebbank.gage.model;

import javax.persistence.*;

/**
 * Created by xn on 2017/3/15.
 */
@Entity
@Table
public class Warning {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "company_id")
    private Company company;

    private int type;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "from_id")
    private User sender;      //若null，则为系统自动发起

    private int severity;

    @Column(name = "send_range")
    private int sendRange;
    private int status;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "handle_id")
    private User handler;      //若null，则为系统自动发起

    private String note;

    //constructor
    public Warning() {
    }

    public Warning(int id) {
        this.id = id;
    }

    public Warning(Company company, int type, User sender, int severity, int sendRange, int status) {
        this.company = company;
        this.type = type;
        this.sender = sender;
        this.severity = severity;
        this.sendRange = sendRange;
        this.status = status;
    }

    //Getter and Setter
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public int getSeverity() {
        return severity;
    }

    public void setSeverity(int severity) {
        this.severity = severity;
    }

    public int getSendRange() {
        return sendRange;
    }

    public void setSendRange(int sendRange) {
        this.sendRange = sendRange;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public User getHandler() {
        return handler;
    }

    public void setHandler(User handler) {
        this.handler = handler;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
