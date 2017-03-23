package com.cebbank.gage.model;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xn on 2017/3/15.
 */
@Entity
@Table(name = "ex_staff")
public class Staff {
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "com.cebbank.gage.util.StaffIdGenerator")
    private int id;
    private String name;

    @Column(name = "id_card")
    private String idCard;
    private String telephone;

    @Column(name = "hire_date", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date hireDate = null;
    private int level;  //  职级
    private String post;    //职位

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "department_id")
    private Department department;
    private String note;

    //外键关联属性
    @JsonIgnore
    @OneToMany(mappedBy = "accountManager", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Set<Contract> contracts = new HashSet<Contract>();

    @JsonIgnore
    @OneToMany(mappedBy = "coManager", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Set<Contract> coContracts = new HashSet<Contract>();

    //constructor
    public Staff() {
    }

    public Staff(int id) {
        this.id = id;
    }

    public Staff(String name, int level, String post, Department department) {
        this.name = name;
        this.level = level;
        this.post = post;
        this.department = department;
    }

    public Staff(String name, Date hireDate, int level, String post, Department department) {
        this.name = name;
        this.hireDate = hireDate;
        this.level = level;
        this.post = post;
        this.department = department;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
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

    public Set<Contract> getCoContracts() {
        return coContracts;
    }

    public void setCoContracts(Set<Contract> coContracts) {
        this.coContracts = coContracts;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", idCard='" + idCard + '\'' +
                ", telephone='" + telephone + '\'' +
                ", hireDate=" + hireDate +
                ", level=" + level +
                ", post='" + post + '\'' +
                ", department=" + department +
                ", note='" + note + '\'' +
                '}';
    }
}
