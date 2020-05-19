/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.sql.Clob;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author syahirghariff
 */
@Entity
@Table(name = "JobDetail")
public class JobDetail implements Serializable {

    @Id
    @Column(name = "JD_ID")
    private String id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "JD_J_ID")
    private Job job;

    @Column(name = "JD_POST")
    private Clob post;

    @Column(name = "JD_POST")
    private String project;

    @Column(name = "JD_ACTIVE")
    private String active;

    @Column(name = "JD_INSERT_DATE")
    private Date insertDate;

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

    public Clob getPost() {
        return post;
    }

    public void setPost(Clob post) {
        this.post = post;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
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
        return "JobDetail{" + "id=" + id + ", job=" + job + ", post=" + post + ", active=" + active + ", insertDate=" + insertDate + '}';
    }

}
