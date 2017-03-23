package com.cebbank.gage.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

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

    //外键关联属性
    @JsonIgnore
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @OrderBy(value = "fromDate DESC")
    private Set<Contract> contracts = new HashSet<Contract>();

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

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
