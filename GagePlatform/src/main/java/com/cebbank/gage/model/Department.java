package com.cebbank.gage.model;

import javax.persistence.*;

/**
 * Created by xn on 2017/3/16.
 */
@Entity
@Table(name = "st_department")
public class Department {
    @Id
    @GeneratedValue
    private int id;
    private String name;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "organization_id")
    private Organization organization;
    private String note;

    //Constructor
    public Department(){

    }

    public Department(int id){
        this.id = id;
    }

    public Department(String name, Organization organization) {
        this.name = name;
        this.organization = organization;
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
