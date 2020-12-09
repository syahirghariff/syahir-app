/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.entity;

import com.syahirghariff.syahirghariff.enums.StatusEnum;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author syahirghariff
 */
@Entity
@Table(name = "MAIN_USER")
public class MainUser implements Serializable{
    
    @Id
    @Column(name="MU_ID")
    private String id;
    
    @Column(name="MU_USERNAME")
    private String username; 
    
    @Column(name="MU_PASSWORD")
    private String password; 
    
    @Column(name="MU_TOKEN")
    private String token; 
    
    @Column(name="MU_ROLE")
    private String role; 
    
    @Column(name="MU_ACTIVE")
    @Enumerated(EnumType.STRING)
    private StatusEnum active;
    
    @Column(name="MU_INSERT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void setToken(String token){
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    @Override
    public String toString() {
        return "MainUser{" + "id=" + id + ", username=" + username + ", password=" + password + ", role=" + role + ", active=" + active + ", insertDate=" + insertDate + '}';
    }
}
