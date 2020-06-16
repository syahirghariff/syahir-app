/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.service;

import com.syahirghariff.syahirghariff.entity.LoginTrx;

/**
 *
 * @author syahirghariff
 */
public interface LoginTrxService {
    
    public LoginTrx createTrx(String username, String password);
}
