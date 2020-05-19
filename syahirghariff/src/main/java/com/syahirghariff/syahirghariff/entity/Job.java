/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author syahirghariff
 */
@Entity
@Table(name="JOB")
public class Job implements Serializable {
    
    @Id
    @Column(name="J_ID")
    private String id; 
    
    @Column(name="J_NAME")
    private String name; 
    
    @Column(name="J_YEAER")
    private String year;
    
    @Column(name="J_ACTIVE")
    private String active; 
    
    @Column(name="J_INSERT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    
    @OneToMany(mappedBy = "job")
    private List<JobDetail> jobDetails; 

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

    public List<JobDetail> getJobDetails() {
        return jobDetails;
    }

    public void setJobDetails(List<JobDetail> jobDetails) {
        this.jobDetails = jobDetails;
    }

    @Override
    public String toString() {
        return "Job{" + "id=" + id + ", name=" + name + ", year=" + year + ", active=" + active + ", insertDate=" + insertDate + '}';
    }
    
    
    
}
