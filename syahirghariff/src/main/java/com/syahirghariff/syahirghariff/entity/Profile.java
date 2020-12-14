/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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

/**
 *
 * @author syahirghariff
 */
@Entity
@Table(name = "PROFILE")
public class Profile extends Base implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "P_ID")
    @JsonInclude(Include.NON_NULL)
    private String id;

    @Column(name = "P_TYPE")
    @JsonInclude(Include.NON_NULL)
    private String type;

    @Column(name = "P_NAME")
    @JsonInclude(Include.NON_NULL)
    private String name;

    @Column(name = "P_SVG")
    @JsonInclude(Include.NON_NULL)
    private String svg;

    @Column(name = "P_IMAGE")
    @JsonIgnore
    private Blob image;

    @Column(name = "P_ACTIVE")
    @JsonInclude(Include.NON_NULL)
    private String active;

    @Column(name = "P_INSERT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonInclude(Include.NON_NULL)
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

    public static Profile create(Profile req) {

        Profile profile = new Profile();
        profile.id = req.getId() != null ? req.getId() : UUID.randomUUID().toString();
        profile.active = Strings.trimToNull(req.getActive());
        profile.insertDate = new Date();
        profile.name = Strings.trimToNull(req.getName().trim());
        profile.type = Strings.trimToNull(req.getType().trim());
        profile.image = req.getEncodeImg() != null ? ImageEncodeDecodeUtil.base64ToBlob(req.getEncodeImg()) : null;
        profile.encodeImg = Strings.trimToNull(req.getEncodeImg());
        profile.svg = Strings.trimToNull(req.getSvg());
        
        return profile;
    }
    
    public static List<Profile> load(List<Profile> req) {
        
        List<Profile> res = new ArrayList<>();
        
        req.stream().forEach(profile -> {
            profile.encodeImg = profile.image != null ? ImageEncodeDecodeUtil.blobToBase64(profile.image) : null;
            res.add(profile);
        });
        
        return res;
    }
    
    public static List<Profile> display(List<Profile> req){
    
        List<Profile> res = new ArrayList<>();
        
        req.stream().forEach(profile -> {
            profile.encodeImg = profile.image != null ? ImageEncodeDecodeUtil.blobToBase64(profile.image) : null;
            profile.id = null;
            profile.insertDate = null;
            profile.active = null; 
            
            res.add(profile);
        });
        
        return res;
    
    }
    @Override
    public String toString() {
        return "Profile{" + "id=" + id + ", type=" + type + ", name=" + name + ", svg=" + svg + ", image=" + image + ", active=" + active + ", insertDate=" + insertDate + '}';
    }

}
