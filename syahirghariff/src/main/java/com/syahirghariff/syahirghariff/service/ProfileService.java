/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.service;

import com.syahirghariff.syahirghariff.entity.Profile;
import java.util.List;

/**
 *
 * @author syahirghariff
 */
public interface ProfileService {
    
    public List<Profile> saveOrUpdate (List<Profile> req);
    
    public List<Profile> findAll();
    
    public List<Profile> display();
    
    public Profile findById(String id);
    
    public boolean deleteById(String id);
    
}
