package com.cebbank.gage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * Created by mark on 4/24/15.
 */

@Entity
@Table
public class User implements Serializable {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private RoleEnum roleId;
    private String password;
    private String telephone;
    private Date registerTime;
    private int status;
    private Date lastLoginTime;
    private Date lastChangeTime;
    private String note;

    @Size(min = 3)
    private String username;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
