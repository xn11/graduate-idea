package com.cebbank.gage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by xn on 2017/3/15.
 */
@Entity
@Table(name = "ex_company")
public class Company {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int type;
    private String address;
    private String contact;
    private String telephone;
    private double score;
    private String note;

    //constructor
    public Company() {
    }

    public Company(int id) {
        this.id = id;
    }

    public Company(String name, int type, double score) {
        this.name = name;
        this.type = type;
        this.score = score;
    }

    //Getter and setter
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

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
