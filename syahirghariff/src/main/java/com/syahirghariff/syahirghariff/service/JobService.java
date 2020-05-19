/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.service;

import com.syahirghariff.syahirghariff.entity.Job;
import java.util.List;

/**
 *
 * @author syahirghariff
 */
public interface JobService {
    
    public List<Job> findAll();
    
    public Job findById (String id);
    
    public Job saveOrUpdate(Job job);
    
    public Job deactivate(String id);
    
}
