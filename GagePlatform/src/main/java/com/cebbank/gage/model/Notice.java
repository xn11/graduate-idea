package com.cebbank.gage.model;

import com.cebbank.gage.common.NoticeStatusTypeEnum;
import com.cebbank.gage.common.NoticeTypeEnum;
import com.cebbank.gage.util.DateJsonSerializer;
import org.codehaus.jackson.map.annotate.JsonSerialize;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by xn on 2017/4/15.
 */
@Entity
@Table
public class Notice {
    @Id
    @GeneratedValue
    private int id;

    //出质通知书、结清通知书、质押物变更通知书、提货通知书、比对错误通知书
    private NoticeTypeEnum type;

    //用于其他通知单，出质为空
//    @ManyToOne(cascade = {CascadeType.MERGE})
//    @JoinColumn(name = "company_id")
//    private Company company;

    //用于出质，其他通知单只取company信息
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "contract_id")
    private Contract contract;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "director_id")
    private User director;

    //待审批、退回、竞价中；线下处理中；待确认、已确认（上传仓单）
    private NoticeStatusTypeEnum status;

    @JsonSerialize(using = DateJsonSerializer.class)
    @Column(columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Date timestamp;

    //监管公司确认时间
    @JsonSerialize(using = DateJsonSerializer.class)
    @Column(name = "check_time", columnDefinition = "timestamp default CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
    private Date checkTime;

    @Column(name = "attach_path")
    private String attachPath;
    private String note;

    //外键关联属性
//    @JsonIgnore
//    @OneToMany(mappedBy = "notice", fetch = FetchType.LAZY, cascade = {CascadeType.ALL})
    @OneToMany(mappedBy = "notice", fetch=FetchType.EAGER, cascade = {CascadeType.ALL})
    private Set<NoticeGage> gages = new HashSet<NoticeGage>();

    //constructor
    public Notice() {
    }

    public Notice(int id) {
        this.id = id;
    }

    public Notice(NoticeTypeEnum type, Contract contract, User director) {
        this.type = type;
        this.contract = contract;
        this.director = director;
        this.status = NoticeStatusTypeEnum.APPROVAL_PENDING;
    }

    public Notice(int id, NoticeTypeEnum type, Contract contract, User director, NoticeStatusTypeEnum status, Date timestamp, Date checkTime, String attachPath, String note) {
        this.id = id;
        this.type = type;
        this.contract = contract;
        this.director = director;
        this.status = status;
        this.timestamp = timestamp;
        this.checkTime = checkTime;
        this.attachPath = attachPath;
        this.note = note;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public NoticeTypeEnum getType() {
        return type;
    }

    public void setType(NoticeTypeEnum type) {
        this.type = type;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public User getDirector() {
        return director;
    }

    public void setDirector(User director) {
        this.director = director;
    }

    public NoticeStatusTypeEnum getStatus() {
        return status;
    }

    public void setStatus(NoticeStatusTypeEnum status) {
        this.status = status;
    }
    public void setStatus(int status) {
        this.status = NoticeStatusTypeEnum.values()[status];
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getAttachPath() {
        return attachPath;
    }

    public void setAttachPath(String attachPath) {
        this.attachPath = attachPath;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<NoticeGage> getGages() {
        return gages;
    }

    public void setGages(Set<NoticeGage> gages) {
        this.gages = gages;
    }
}
