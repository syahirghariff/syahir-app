/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.entity;

import java.io.Serializable;
import java.util.Date;
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
@Table(name="GENERAL")
public class General implements Serializable {
    
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name="G_ID")
    private String id; 
    
    @Column(name="G_CODE")
    private String code; 
    
    @Column(name="G_DESC")
    private String desc;
    
    @Column(name="G_INSERT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate; 

    public General() {
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }
    
    
    
    public static General create(General req) {
        General general = new General();
        general.id = req.getId() != null ? req.getId() : UUID.randomUUID().toString(); 
        general.code = Strings.trimToNull(req.getCode());
        general.desc = Strings.trimToNull(req.getDesc());
        general.insertDate = new Date();
        
        return general;
    }

    @Override
    public String toString() {
        return "General{" + "id=" + id + ", code=" + code + ", desc=" + desc + ", insertDate=" + insertDate + '}';
    }
    
    
}
