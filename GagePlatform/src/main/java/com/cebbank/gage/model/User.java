package com.cebbank.gage.model;

import com.cebbank.gage.common.RoleEnum;
import com.cebbank.gage.util.DateJsonSerializer;
import com.cebbank.gage.util.DateTimeJsonSerializer;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xn on 2017/3/6.
 * <p>
 * 系统用户类
 */
@Entity
@Table
public class User implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    //用户角色
    @Column(name = "role_id")
    private RoleEnum role;

    private String password;
    private String telephone;

    //注册时间
    @JsonSerialize(using = DateJsonSerializer.class)
    @Column(name = "register_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date registerTime = null;
    private int status;

    //上次登录时间
    @JsonSerialize(using = DateTimeJsonSerializer.class)
    @Column(name = "last_login_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date lastLoginTime = null;

    //上次信息变更时间
    @JsonSerialize(using = DateTimeJsonSerializer.class)
    @Column(name = "last_change_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date lastChangeTime = null;

    private String note;

    //外键关联属性
    @JsonIgnore
    @ManyToMany(fetch = FetchType.LAZY, mappedBy = "receivers")
    private Set<Warning> receiveWarnings = new HashSet<Warning>();

    @JsonIgnore
    @OneToMany(mappedBy = "sender", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @OrderBy(value = "id DESC")
    private Set<Warning> sendWarnings = new HashSet<Warning>();

    @JsonIgnore
    @OneToMany(mappedBy = "handler", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @OrderBy(value = "id DESC")
    private Set<Warning> handleWarnings = new HashSet<Warning>();

//    @JsonIgnore
//    @OneToMany(mappedBy = "accountManager", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
//    @OrderBy(value = "from_date DESC")
//    private Set<Contract> contracts = new HashSet<Contract>();

    //Constructors
    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String name, int roleId, String password) {
        this.name = name;
        this.role = RoleEnum.values()[roleId];
        this.password = password;
    }

    public User(String name, int roleId, String password, String telephone, String note) {
        this.name = name;
        this.role = RoleEnum.values()[roleId];
        this.password = password;
        this.telephone = telephone;
        this.note = note;
    }

    public User(int id, String name, RoleEnum role, String password, String telephone, Date registerTime, int status, Date lastLoginTime, Date lastChangeTime, String note) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.password = password;
        this.telephone = telephone;
        this.registerTime = registerTime;
        this.status = status;
        this.lastLoginTime = lastLoginTime;
        this.lastChangeTime = lastChangeTime;
        this.note = note;
    }

    //Getters and Setters
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

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Date getLastChangeTime() {
        return lastChangeTime;
    }

    public void setLastChangeTime(Date lastChangeTime) {
        this.lastChangeTime = lastChangeTime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<Warning> getReceiveWarnings() {
        return receiveWarnings;
    }

    public void setReceiveWarnings(Set<Warning> receiveWarnings) {
        this.receiveWarnings = receiveWarnings;
    }

    public Set<Warning> getSendWarnings() {
        return sendWarnings;
    }

    public void setSendWarnings(Set<Warning> sendWarnings) {
        this.sendWarnings = sendWarnings;
    }

    public Set<Warning> getHandleWarnings() {
        return handleWarnings;
    }

    public void setHandleWarnings(Set<Warning> handleWarnings) {
        this.handleWarnings = handleWarnings;
    }

    /*public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }*/
}
