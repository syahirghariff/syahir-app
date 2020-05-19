/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.service;

import com.syahirghariff.syahirghariff.entity.Tech;
import java.util.List;

/**
 *
 * @author syahirghariff
 */
public interface TechService {
    
    public List<Tech> findAll();
    
    public List<Tech> findAllActive();
    
    public Tech saveOrUpdate(Tech tech); 
    
    public Tech deactivate(Tech tech);
    
}
