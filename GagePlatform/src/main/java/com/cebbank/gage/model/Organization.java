package com.cebbank.gage.model;

import com.cebbank.gage.util.GageUtils;
import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by xn on 2017/3/17.
 */
@Entity
@Table(name = "st_organization")
public class Organization {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private int level;
    private String address;
    private String phone;

    @JsonIgnore
    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "parent_id")
    private Organization parentOrg;
    private String note;

    //treeview 文本属性，不与数据库映射
    @Transient
    private String text;
    @Transient
    private List<String> tags = new ArrayList<String>();
    ;

    //外键关联属性
    //    @JsonIgnore
    @OneToMany(mappedBy = "parentOrg", fetch = FetchType.LAZY, cascade = {CascadeType.MERGE})
    @OrderBy(value = "id DESC")
    private Set<Organization> nodes = new HashSet<Organization>();

    //Constructor
    public Organization() {
    }

    public Organization(int id) {
        this.id = id;
    }

    public Organization(String name, int level, Organization parentOrg) {
        this.name = name;
        this.level = level;
        this.parentOrg = parentOrg;
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

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Organization getParentOrg() {
        return parentOrg;
    }

    public void setParentOrg(Organization parentOrg) {
        this.parentOrg = parentOrg;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Set<Organization> getNodes() {
        if (nodes.size() <= 0) {
            return null;
        }
        return nodes;
    }

    public void setNodes(Set<Organization> nodes) {
        this.nodes = nodes;
    }

    public String getText() {
        return name + "   (" + nodes.size() + ")";
    }

    public void setText(String text) {
        this.text = text;
    }


    public List<String> getTags() {
        if (tags.isEmpty()) {
            tags.add("电话：" + GageUtils.nullToString(phone));
            tags.add("地址：" + GageUtils.nullToString(address));
        }
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
