/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.service;

import com.syahirghariff.syahirghariff.entity.General;
import java.util.List;

/**
 *
 * @author syahirghariff
 */
public interface GeneralService {
    
    public General saveOrUpdate(General svg);
    
    public List<General> findAll(); 
    
    public General findByCode(String code);
    
}
