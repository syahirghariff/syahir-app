/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.entity;

import java.io.Serializable;
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
@Table(name="EDUCATION")
public class Education implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="E_ID")
    private String id; 
    
    @Column(name="E_NAME")
    private String name; 
    
    @Column(name="E_COURSE")
    private String course;
    
    @Column(name="E_YEAR")
    private String year; 
    
    @Column(name="E_ACTIVE")
    private String active; 
    
    @Column(name="E_INSERT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate; 

    public Education() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
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
        return "Education{" + "id=" + id + ", name=" + name + ", course=" + course + ", year=" + year + ", active=" + active + ", insertDate=" + insertDate + '}';
    }
    
}
