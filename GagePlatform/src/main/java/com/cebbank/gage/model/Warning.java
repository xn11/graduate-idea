package com.cebbank.gage.model;

import com.cebbank.gage.common.StatusTypeEnum;
import com.cebbank.gage.common.WarningTypeEnum;
import com.cebbank.gage.util.DateTimeJsonSerializer;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xn on 2017/3/15.
 */
@Entity
@Table
public class Warning {
    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "company_id")
    private Company company;

    private WarningTypeEnum type;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "from_id")
    private User sender;      //若null，则为系统自动发起

    private int severity;

    //    @Column(name = "send_range")
//    private int sendRange;
    private StatusTypeEnum status;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "handle_id")
    private User handler;      //若null，则为系统自动发起

    @JsonSerialize(using = DateTimeJsonSerializer.class)
    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date timestamp = null;
    private String note;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(name = "warning_user",
            joinColumns = {@JoinColumn(name = "warning_id")},
            inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> receivers = new HashSet<User>();

    //constructor
    public Warning() {
    }

    public Warning(int id) {
        this.id = id;
    }

    public Warning(Company company, WarningTypeEnum type, User sender, int severity, String note) {
        this.company = company;
        this.type = type;
        this.sender = sender;
        this.severity = severity;
        this.note = note;
        this.status = StatusTypeEnum.UNPROCESSED;
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

    public WarningTypeEnum getType() {
        return type;
    }

    public void setType(WarningTypeEnum type) {
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

    public StatusTypeEnum getStatus() {
        return status;
    }

    public void setStatus(StatusTypeEnum status) {
        this.status = status;
    }

    public User getHandler() {
        return handler;
    }

    public void setHandler(User handler) {
        this.handler = handler;
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

    public Set<User> getReceivers() {
        return receivers;
    }

    public void setReceivers(Set<User> receivers) {
        this.receivers = receivers;
    }
}
