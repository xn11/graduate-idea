package com.cebbank.gage.model;

import javax.persistence.*;

/**
 * Created by xn on 2017/3/17.
 */
@Entity
@Table(name = "st_organization")
public class Organization {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int level;
    private String address;
    private String phone;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "parent_id")
    private Organization parentOrg;
    private String note;

    //Constructor
    public Organization() {
    }

    public Organization(int id){
        this.id = id;
    }

    public Organization(String name, int level, Organization parentOrg) {
        this.name = name;
        this.level = level;
        this.parentOrg = parentOrg;
    }

    //Getter and Setter
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Organization getParentOrg() {
        return parentOrg;
    }

    public void setParentOrg(Organization parentOrg) {
        this.parentOrg = parentOrg;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
