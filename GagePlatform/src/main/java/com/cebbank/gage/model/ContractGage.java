package com.cebbank.gage.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by xn on 2017/3/15.
 */
@Entity
@Table(name = "contract_gage")
public class ContractGage {
    @Id
    @GeneratedValue
    private int id;

    @JsonIgnore
    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne(cascade={CascadeType.MERGE})
    @JoinColumn(name = "gage_id")
    private Gage gage;

    private double quantity;
    private String specification;   //规格
    private int status;
    private String note;

    //constructor
    public ContractGage() {
    }

    public ContractGage(int id) {
        this.id = id;
    }

    public ContractGage(Contract contract, Gage gage, double quantity, String specification, int status) {
        this.contract = contract;
        this.gage = gage;
        this.quantity = quantity;
        this.specification = specification;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public Gage getGage() {
        return gage;
    }

    public void setGage(Gage gage) {
        this.gage = gage;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
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
}
