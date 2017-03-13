package com.cebbank.gage.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by xn on 2017/3/6.
 *
 * 系统用户类
 */
@Entity
@Table
public class User implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @Column(name = "role_id")
    private int roleId;
//    private RoleEnum roleId;

    private String password;
    private String telephone;

    @Column(name = "register_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date registerTime = null;
    private int status;

    @Column(name = "last_login_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date lastLoginTime = null;

    @Column(name = "last_change_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date lastChangeTime = null;

    private String note;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(String name, int roleId, String password) {
        this.name = name;
        this.roleId = roleId;
        this.password = password;
    }


    public User(String name, int roleId, String password, String telephone, Date registerTime, int status, Date lastLoginTime, Date lastChangeTime, String note) {
        this.id = 0;
        this.name = name;
        this.roleId = roleId;
        this.password = password;
        this.telephone = telephone;
        this.registerTime = registerTime;
        this.status = status;
        this.lastLoginTime = lastLoginTime;
        this.lastChangeTime = lastChangeTime;
        this.note = note;
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

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
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
}
