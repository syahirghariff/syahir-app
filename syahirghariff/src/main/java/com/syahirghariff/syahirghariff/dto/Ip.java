/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.dto;

import java.math.BigDecimal;

/**
 *
 * @author syahirghariff
 */
public class Ip {
    
    private String ip; 
    private String city;
    private String region; 
    private String country_name; 
    private BigDecimal latitude;
    private BigDecimal longitude; 
    private String postal; 
    private String org; 

    public Ip() {
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

    public String getCountry_name() {
        return country_name;
    }

    public void setCountry_name(String country_name) {
        this.country_name = country_name;
    }

    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
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

    @Override
    public String toString() {
        return "Ip{" + "ip=" + ip + ", city=" + city + ", region=" + region + ", country_name=" + country_name + ", latitude=" + latitude + ", longitude=" + longitude + ", postal=" + postal + ", org=" + org + '}';
    }
    
}
