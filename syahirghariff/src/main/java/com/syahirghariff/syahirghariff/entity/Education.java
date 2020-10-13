/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.syahirghariff.syahirghariff.util.ImageEncodeDecodeUtil;
import java.io.Serializable;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.logging.log4j.util.Strings;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author syahirghariff
 */
@Entity
@Table(name = "EDUCATION")
public class Education extends Base implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "E_ID")
    private String id;

    @Column(name = "E_NAME")
    private String name;

    @Column(name = "E_COURSE")
    private String course;

    @Column(name = "E_YEAR")
    private String year;

    @Column(name = "E_ACTIVE")
    private String active;

    @Column(name = "E_IMAGE")
    @JsonIgnore
    private Blob image;

    @Column(name = "E_INSERT_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
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

    public Blob getImage() {
        return image;
    }

    public void setImage(Blob image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Education{" + "id=" + id + ", name=" + name + ", course=" + course + ", year=" + year + ", active=" + active + ", insertDate=" + insertDate + '}';
    }
    
    public static List<Education> load(List<Education> req) {
        List<Education> res = new ArrayList<>();

        req.stream().forEach(education -> {
            education.encodeImg = education.image != null ? ImageEncodeDecodeUtil.blobToBase64(education.image) : null;
            res.add(education);
        });
        return res;
    
    }

    public static Education create(Education req) {
        Education education = new Education();

        education.active = Strings.trimToNull(req.getActive());
        education.id = req.getId() != null ? req.getId() : UUID.randomUUID().toString();
        education.name = Strings.trimToNull(req.getName());
        education.course = Strings.trimToNull(req.getCourse());
        education.year = Strings.trimToNull(req.getYear());
        education.insertDate = new Date();
        education.image = req.getEncodeImg() != null ? ImageEncodeDecodeUtil.base64ToBlob(req.getEncodeImg()) : null;
        education.encodeImg = Strings.trimToNull(req.getEncodeImg());

        return education;
    }

}
