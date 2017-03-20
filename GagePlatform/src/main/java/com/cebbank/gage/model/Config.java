package com.cebbank.gage.model;

import javax.persistence.*;

/**
 * Created by xn on 2017/3/15.
 */
@Entity
@Table(name = "_config")
public class Config {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String value;

    //constructor
    public Config() {
    }

    public Config(int id) {
        this.id = id;
    }

    public Config(String name, String value) {
        this.name = name;
        this.value = value;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
