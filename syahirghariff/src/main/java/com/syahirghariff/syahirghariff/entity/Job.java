/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.syahirghariff.syahirghariff.enums.StatusEnum;
import com.syahirghariff.syahirghariff.util.ImageEncodeDecodeUtil;
import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.logging.log4j.util.Strings;

/**
 *
 * @author syahirghariff
 */
@Entity
@Table(name="JOB")
public class Job extends Base implements Serializable {
    
    @Id
    @Column(name="J_ID")
    private String id; 
    
    @Column(name="J_COMPANY_NAME")
    private String companyName; 
    
    @Column(name="J_IMAGE")
    @JsonIgnore
    private Blob image;
    
    @Column(name="J_TITLE")
    private String title; 
    
    @Column(name="J_YEAR")
    private String year;
    
    @Column(name="J_ACTIVE")
    @Enumerated(EnumType.STRING)
    private StatusEnum active; 
    
    @Column(name="J_INSERT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;
    
    @OneToOne(mappedBy = "job", cascade = CascadeType.ALL)
    private JobDetail jobDetail; 

    public Job() {
    }

    
    public static Job create(Job req) {
    
        Job job = new Job();
        job.id = req.getId() == null ? UUID.randomUUID().toString() : req.getId();
        job.companyName = Strings.trimToNull(req.getCompanyName());
        job.image = req.getEncodeImg() != null ? ImageEncodeDecodeUtil.base64ToBlob(req.getEncodeImg()) : null; 
        job.title = Strings.trimToNull(req.getTitle());
        job.year = Strings.trimToNull(req.getYear());
        job.insertDate = new Date();
        job.active = req.getActive();
        job.encodeImg = req.getEncodeImg();
        
        return job;
    }
    
    public static Job prepare (Job req, JobDetail jobDetail) {
    
        Job job = Job.create(req);
        job.jobDetail = jobDetail != null ? jobDetail : null;
        
        return job;
    }
    
    public static Job load (Job req) {
    
        Job job = new Job();
        job.id = req.getId() == null ? UUID.randomUUID().toString() : req.getId();
        job.companyName = Strings.trimToNull(req.getCompanyName());
        job.image = req.getEncodeImg() != null ? ImageEncodeDecodeUtil.base64ToBlob(req.getEncodeImg()) : null; 
        job.title = Strings.trimToNull(req.getTitle());
        job.year = Strings.trimToNull(req.getYear());
        job.insertDate = new Date();
        job.active = req.getActive();
        job.encodeImg = req.getImage() != null ? ImageEncodeDecodeUtil.blobToBase64(req.getImage()) : null;
        job.jobDetail = req.getJobDetail() != null ? req.getJobDetail() : null;
        
        return job;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public StatusEnum getActive() {
        return active;
    }

    public void setActive(StatusEnum active) {
        this.active = active;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    public JobDetail getJobDetail() {
        return jobDetail;
    }

    public void setJobDetail(JobDetail jobDetail) {
        this.jobDetail = jobDetail;
    }

    @Override
    public String toString() {
        return "Job{" + "id=" + id + ", companyName=" + companyName + ", image=" + image + ", title=" + title + ", year=" + year + ", active=" + active + ", insertDate=" + insertDate + ", jobDetail=" + jobDetail + '}';
    }
    
}
