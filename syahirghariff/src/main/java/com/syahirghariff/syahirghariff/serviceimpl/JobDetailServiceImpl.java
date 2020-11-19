/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.serviceimpl;

import com.syahirghariff.syahirghariff.dao.JobDetailDao;
import com.syahirghariff.syahirghariff.entity.Job;
import com.syahirghariff.syahirghariff.entity.JobDetail;
import org.springframework.stereotype.Service;
import com.syahirghariff.syahirghariff.service.JobDetailService;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author syahirghariff
 */
@Service
public class JobDetailServiceImpl implements JobDetailService {

    @Autowired
    private JobDetailDao jobDetailDao;

    @Override
    @Transactional
    public JobDetail saveJobDetail(JobDetail req) {
        return jobDetailDao.saveOrUpdate(req);
    }

    @Override
    @Transactional 
    public boolean deleteByJob(Job job) {
        
        JobDetail jobDetail = jobDetailDao.findByJob(job);
        
        if (jobDetail != null) {
            jobDetailDao.deleteById(jobDetail.getId());
            return true; 
        }
        
        return false; 
    }
    
    

}
