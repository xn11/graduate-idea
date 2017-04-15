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
/*@Entity
@Table(name = "regulators_company")
public class RegulatorsCompany {
    @Id
    @GeneratedValue(generator = "idGenerator")
    @GenericGenerator(name = "idGenerator", strategy = "com.cebbank.gage.util.RegulatorIdGenerator")
    private int id;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "company_id")
    private Company company;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "regulators_id")
    private Regulators regulators;

    @Column(name = "from_date", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date fromDate;

    @Column(name = "to_date", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date toDate;

    private double fee; //监管费百分比
    private int status;
    private String note;

    //外键关联属性
    @JsonIgnore
    @OneToMany(mappedBy = "regulator", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Set<RegulateAccount> regulateAccounts = new HashSet<RegulateAccount>();


    //constructor
    public RegulatorsCompany() {
    }

    public RegulatorsCompany(int id) {
        this.id = id;
    }

    public RegulatorsCompany(Company company, Regulators regulators, Date fromDate, Date toDate, double fee, int status) {
        this.company = company;
        this.regulators = regulators;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.fee = fee;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Regulators getRegulators() {
        return regulators;
    }

    public void setRegulators(Regulators regulators) {
        this.regulators = regulators;
    }

    public Date getFromDate() {
        return fromDate;
    }

    public void setFromDate(Date fromDate) {
        this.fromDate = fromDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<RegulateAccount> getRegulateAccounts() {
        return regulateAccounts;
    }

    public void setRegulateAccounts(Set<RegulateAccount> regulateAccounts) {
        this.regulateAccounts = regulateAccounts;
    }
}*/
