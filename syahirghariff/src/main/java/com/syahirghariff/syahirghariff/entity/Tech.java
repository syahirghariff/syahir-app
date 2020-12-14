/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.io.Serializable;
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
@Table(name="TECH")
public class Tech implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="T_ID")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String id; 
    
    @Column(name="T_TYPE")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String type; 
    
    @Column(name="T_SEQ")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer seq; 
    
    @Column(name="T_NAME")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String name; 
    
    @Column(name="T_SVG")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String svg; 
    
    @Column(name="T_ACTIVE")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String active; 
    
    @Column(name="T_INSERT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Date insertDate; 

    public Tech() {
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

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getSvg() {
        return svg;
    }

    public void setSvg(String svg) {
        this.svg = svg;
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
        return "Tech{" + "id=" + id + ", type=" + type + ", name=" + name + ", svg=" + svg + ", active=" + active + ", insertDate=" + insertDate + '}';
    }
    
    public static Tech create (Tech req){
    
        Tech tech = new Tech();
        tech.id = req.getId() != null ? Strings.trimToNull(req.getId()) : UUID.randomUUID().toString();
        tech.type = Strings.trimToNull(req.getType());
        tech.seq = req.seq;
        tech.name = Strings.trimToNull(req.getName());
        tech.svg = Strings.trimToNull(req.getSvg());
        tech.active = Strings.trimToNull(req.getActive());
        tech.insertDate = new Date();
        
        return tech;
    }
    
    public static List<Tech> display (List<Tech> req) {
    
        List<Tech> res = new ArrayList<>();
        
        req.stream().forEach(tech-> {
            tech.id = null;
            tech.insertDate = null;
            tech.active = null;
            
            res.add(tech);
        });
        return res; 
    }
    
}
