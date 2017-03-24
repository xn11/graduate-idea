package com.cebbank.gage.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xn on 2017/3/15.
 */
@Entity
@Table(name = "regulators")
public class Regulators {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String address;
    private String contact;
    private String telephone;
    private String email;
    private double score;
    private String note;

    //外键关联属性
    @JsonIgnore
    @OneToMany(mappedBy = "regulators", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Set<RegulatorsCompany> companies = new HashSet<RegulatorsCompany>();

    //constructor
    public Regulators() {
    }

    public Regulators(int id) {
        this.id = id;
    }

    public Regulators(String name, String contact, String telephone, double score) {
        this.name = name;
        this.contact = contact;
        this.telephone = telephone;
        this.score = score;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Set<RegulatorsCompany> getCompanies() {
        return companies;
    }

    public void setCompanies(Set<RegulatorsCompany> companies) {
        this.companies = companies;
    }
}
