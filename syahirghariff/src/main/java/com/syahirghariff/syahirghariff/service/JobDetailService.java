/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.service;

import com.syahirghariff.syahirghariff.entity.Job;
import com.syahirghariff.syahirghariff.entity.JobDetail;

/**
 *
 * @author syahirghariff
 */
public interface JobDetailService {
    
    public JobDetail saveJobDetail(JobDetail jobDetail);
    
    public boolean deleteByJob (Job job);
    
}
