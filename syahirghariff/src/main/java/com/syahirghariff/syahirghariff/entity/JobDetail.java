/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.syahirghariff.syahirghariff.enums.StatusEnum;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.apache.logging.log4j.util.Strings;

/**
 *
 * @author syahirghariff
 */
@Entity
@Table(name = "JOB_DETAIL")
public class JobDetail implements Serializable {

    @Id
    @Column(name = "JD_ID")
    private String id;

    @JsonIgnore
    @OneToOne
    @JoinColumn(name = "JD_J_ID")
    private Job job;

    @Column(name = "JD_POST")
    @Lob
    private String post;

    @Column(name = "JD_ACTIVE")
    @Enumerated(EnumType.STRING)
    private StatusEnum active;

    @Column(name = "JD_INSERT_DATE")
    private Date insertDate;
    
    public JobDetail() {
    }
    
    public static JobDetail create (JobDetail req) {
        
        JobDetail jobDetail = new JobDetail(); 
        jobDetail.id = req != null && req.getId() != null ? req.getId() : UUID.randomUUID().toString();
        jobDetail.post = req != null ? Strings.trimToNull(req.getPost()) : null;
        jobDetail.active = req != null ? req.getActive() : StatusEnum.A; 
        jobDetail.insertDate = new Date();
        jobDetail.job = req != null && req.getJob() != null ? req.getJob() : null;
        
        return jobDetail;
    }
    
    public static JobDetail prepare(Job job, JobDetail req) {
    
        JobDetail jobDetail = JobDetail.create(req);
        jobDetail.job = job != null? job : null;
        
        return jobDetail; 
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }
    
    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public StatusEnum getActive() {
        return active;
    }

    public void setActive(StatusEnum active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "JobDetail{" + "id=" + id + ", job=" + job + ", post=" + post + ", active=" + active + ", insertDate=" + insertDate + '}';
    }
    
    
}
