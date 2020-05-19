/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.entity;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author syahirghariff
 */
@Entity
@Table(name="PROFILE")
public class Profile implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="P_ID")
    private String id; 
    
    @Column(name="P_TYPE")
    private String type; 
    
    @Column(name="P_NAME")
    private String name;
    
    @Column(name="P_SVG")
    private String svg; 
    
    @Column(name="P_IMAGE")
    private Blob image; 
    
    @Column(name="P_ACTIVE")
    private String active;
    
    @Column(name="P_INSERT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;

    public Profile() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSvg() {
        return svg;
    }

    public void setSvg(String svg) {
        this.svg = svg;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    @Override
    public String toString() {
        return "Profile{" + "id=" + id + ", type=" + type + ", name=" + name + ", svg=" + svg + ", image=" + image + ", active=" + active + ", insertDate=" + insertDate + '}';
    }
    
}
