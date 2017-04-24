package com.cebbank.gage.model;

import com.cebbank.gage.common.ContractStatusTypeEnum;
import com.cebbank.gage.util.DateJsonSerializer;
import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xn on 2017/3/15.
 */
@Entity
@Table(name = "ex_contract")
public class Contract {
    @Id
    private int id;
    private int type;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "company_id")
    private Company company;

    //客户经理
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "account_manager_id")
    private Staff accountManager;

    //协办
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "co_manager_id")
    private Staff coManager;

    @JsonSerialize(using = DateJsonSerializer.class)
    @Column(name = "from_date", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date fromDate;

    @JsonSerialize(using = DateJsonSerializer.class)
    @Column(name = "to_date", columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date toDate;

    private double loan;

    //0未入库，1待审批，2已入库，3已结清出库，4未结清出库，5处置中，6已处置
    private ContractStatusTypeEnum status;
    private String note;

    //外键关联属性
//    @JsonIgnore
    @OneToMany(mappedBy = "contract", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    private Set<ContractGage> contractGages = new HashSet<ContractGage>();

    @JsonIgnore
    @OneToMany(mappedBy = "contract", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    private Set<Notice> notices = new HashSet<Notice>();


    //constructor
    public Contract() {
    }

    public Contract(int id) {
        this.id = id;
    }

    public Contract(int id, int type, Company company, Staff accountManager, Staff coManager, Date fromDate, Date toDate, double loan, ContractStatusTypeEnum status) {
        this.id = id;
        this.type = type;
        this.company = company;
        this.accountManager = accountManager;
        this.coManager = coManager;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.loan = loan;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Staff getAccountManager() {
        return accountManager;
    }

    public void setAccountManager(Staff accountManager) {
        this.accountManager = accountManager;
    }

    public Staff getCoManager() {
        return coManager;
    }

    public void setCoManager(Staff coManager) {
        this.coManager = coManager;
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

    public double getLoan() {
        return loan;
    }

    public void setLoan(double loan) {
        this.loan = loan;
    }

    public ContractStatusTypeEnum getStatus() {
        return status;
    }

    public void setStatus(ContractStatusTypeEnum status) {
        this.status = status;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<ContractGage> getContractGages() {
        return contractGages;
    }

    public void setContractGages(Set<ContractGage> contractGages) {
        this.contractGages = contractGages;
    }

    public Set<Notice> getNotices() {
        return notices;
    }

    public void setNotices(Set<Notice> notices) {
        this.notices = notices;
    }
}
