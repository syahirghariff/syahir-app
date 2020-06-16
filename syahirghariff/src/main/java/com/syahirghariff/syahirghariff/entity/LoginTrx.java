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
@Table(name = "LOGIN_TRX")
public class LoginTrx implements Serializable{
    
    @Id
    @Column(name="LT_ID")
    private String id; 
    
    @Column(name="LT_USERNAME")
    private String username; 
    
    @Column(name="LT_PASSWORD")
    private String password; 
    
    @Column(name="LT_INSERT_DATE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertDate; 

    public LoginTrx() {
    }

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

    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    @Override
    public String toString() {
        return "LoginTrx{" + "id=" + id + ", username=" + username + ", password=" + password + ", insertDate=" + insertDate + '}';
    }
    
    
    
}
