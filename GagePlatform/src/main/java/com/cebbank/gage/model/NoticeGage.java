package com.cebbank.gage.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;

/**
 * Created by xn on 2017/3/15.
 */
@Entity
@Table(name = "notice_gage")
public class NoticeGage {
    @Id
    @GeneratedValue
    private int id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "notice_id")
    private Notice notice;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "gage_id")
    private Gage gage;

    private double quantity;
    private String note;

    //constructor
    public NoticeGage() {
    }

    public NoticeGage(int id) {
        this.id = id;
    }

    public NoticeGage(Notice notice, Gage gage, double quantity) {
        this.notice = notice;
        this.gage = gage;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Notice getNotice() {
        return notice;
    }

    public void setNotice(Notice notice) {
        this.notice = notice;
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

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
