/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.service;

import com.syahirghariff.syahirghariff.entity.Profile;

/**
 *
 * @author syahirghariff
 */
public interface ProfileService {
    
    public Profile findByType(String type); 
    
    public Profile saveOrUpdate(Profile profile);
    
    public Profile deactivate(String id);
    
}
