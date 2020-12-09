/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.service;

import com.syahirghariff.syahirghariff.entity.MainUser;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author syahirghariff
 */
public interface MainUserService {
    
    public ResponseEntity doLogin(MainUser user); 
        
    public MainUser findUser(String username); 
    
    public boolean authenticate(String token);
    
}
