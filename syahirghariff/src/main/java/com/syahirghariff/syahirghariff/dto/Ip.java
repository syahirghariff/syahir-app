/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.dto;

import com.syahirghariff.syahirghariff.entity.IpUser;
import java.math.BigDecimal;
import java.util.Date;
import org.apache.logging.log4j.util.Strings;

/**
 *
 * @author syahirghariff
 */
public class Ip {
    
    private String ip; 
    private String city;
    private String region; 
    private String country; 
    private BigDecimal latitude;
    private BigDecimal longitude; 
    private String postcode; 
    private String internetProvider; 
    private Date date; 

    public Ip() {
    }
    
    public static Ip load (IpUser req){
        
        Ip ipUser = new Ip();
        ipUser.ip = Strings.trimToNull(req.getIp());
        ipUser.city = Strings.trimToNull(req.getCity());
        ipUser.region = Strings.trimToNull(req.getRegion());
        ipUser.country = Strings.trimToNull(req.getCountry());
        ipUser.latitude = req.getLatitude() != null ? req.getLatitude() : null;
        ipUser.longitude = req.getLatitude() != null ? req.getLongitude() : null; 
        ipUser.postcode = Strings.trimToNull(req.getPostal());
        ipUser.internetProvider = Strings.trimToNull(req.getInternetProvider());
        ipUser.date = req.getInsertDate() != null ? req.getInsertDate() : null;
        
        return ipUser;
    
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

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getInternetProvider() {
        return internetProvider;
    }

    public void setInternetProvider(String internetProvider) {
        this.internetProvider = internetProvider;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Ip{" + "ip=" + ip + ", city=" + city + ", region=" + region + ", country=" + country + ", latitude=" + latitude + ", longitude=" + longitude + ", postcode=" + postcode + ", internetProvider=" + internetProvider + '}';
    }
    
    
}
