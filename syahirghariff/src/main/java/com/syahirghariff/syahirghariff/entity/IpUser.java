/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Date;
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
@Table(name = "IP_USER")
public class IpUser {

    @Id
    @Column(name="IU_ID")
    private String id; 
    
    @Column(name="IU_IP")
    private String ip;
    
    @Column(name="IU_CITY")
    private String city;
    
    @Column(name="IU_REGION")
    private String region;
    
    @Column(name="IU_COUNTRY")
    @JsonProperty("country_name")
    private String country;
    
    @Column(name="IU_LATITUDE")
    private BigDecimal latitude;
    
    @Column(name="IU_LONGITUDE")
    private BigDecimal longitude;
    
    @Column(name="IU_POSTAL")
    private String postal;
    
    @Column(name="IU_INTERNET_PROVIDER")
    @JsonProperty("org")
    private String internetProvider;
    
    @Column(name = "IU_INSERT_DATE")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private Date insertDate;
    
    
    public IpUser(){
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getLatitude() {
        return latitude;
    }

    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    public BigDecimal getLongitude() {
        return longitude;
    }

    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getInternetProvider() {
        return internetProvider;
    }

    public void setInternetProvider(String internetProvider) {
        this.internetProvider = internetProvider;
    }
    
    public Date getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(Date insertDate) {
        this.insertDate = insertDate;
    }

    @Override
    public String toString() {
        return "IpUser{" + "id=" + id + ", ip=" + ip + ", city=" + city + ", region=" + region + ", country=" + country + ", latitude=" + latitude + ", longitude=" + longitude + ", postal=" + postal + ", internetProvider=" + internetProvider + ", insertDate=" + insertDate + '}';
    }
    
    public static IpUser create(IpUser req) {
    
        IpUser ipUser = new IpUser();
        ipUser.id = UUID.randomUUID().toString(); 
        ipUser.ip = Strings.trimToNull(req.getIp()); 
        ipUser.city = Strings.trimToNull(req.getCity());
        ipUser.region = Strings.trimToNull(req.getRegion());
        ipUser.country = Strings.trimToNull(req.getCountry());
        ipUser.latitude = req.getLatitude() != null ? req.getLatitude() : null; 
        ipUser.longitude = req.getLongitude() != null ? req.getLongitude() : null;
        ipUser.postal = Strings.trimToNull(req.getPostal());
        ipUser.internetProvider = Strings.trimToNull(req.getInternetProvider());
        ipUser.insertDate = new Date();
        
        return ipUser;
    }
    
    
    
    

}
