/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import javax.persistence.Transient;

/**
 *
 * @author syahirghariff
 */
abstract class Base {
    
    @Transient
    @JsonInclude(Include.NON_NULL)
    protected String encodeImg; 

    public Base() {
    }

    public String getEncodeImg() {
        return encodeImg;
    }

    public void setEncodeImg(String encodeImg) {
        this.encodeImg = encodeImg;
    }
}
