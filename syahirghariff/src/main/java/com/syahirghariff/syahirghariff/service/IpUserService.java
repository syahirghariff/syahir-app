/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.service;

import com.syahirghariff.syahirghariff.dto.Ip;
import com.syahirghariff.syahirghariff.entity.IpUser;
import java.util.List;

/**
 *
 * @author syahirghariff
 */
public interface IpUserService {

    public void getUserIp();
    
    public IpUser save(IpUser ipUser);
    
    public List<Ip> findAll(); 
}
