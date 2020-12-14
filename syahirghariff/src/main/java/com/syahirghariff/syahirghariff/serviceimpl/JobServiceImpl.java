/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.serviceimpl;

import com.syahirghariff.syahirghariff.dao.JobDao;
import com.syahirghariff.syahirghariff.entity.Job;
import com.syahirghariff.syahirghariff.entity.JobDetail;
import com.syahirghariff.syahirghariff.service.JobDetailService;
import com.syahirghariff.syahirghariff.service.JobService;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author syahirghariff
 */
@Service
public class JobServiceImpl implements JobService{
    
    @Autowired
    private JobDao jobDao;
    
    @Autowired
    private JobDetailService jobDetailSvc;

    @Override
    public List<Job> findAll() {
        
        List<Job> result = new ArrayList<>(); 
        
        jobDao.findAll().stream().forEach((job)-> {
            result.add(Job.load(job));
        });
        
        return result;
    }

    @Override
    public List<Job> display() {
        return Job.display(jobDao.display());
    }
    
    @Override
    @Transactional
    public boolean deleteById(String id) {
        
        Job job = jobDao.findById(id);
        
        if (job != null) {
            
            // Delete JOB_DETAIL
            jobDetailSvc.deleteByJob(job); 
            
            // Delete JOB
            jobDao.deleteById(id);
            
            return true; 
        }
        
        return false;
    }
    
    

    @Override
    @Transactional
    public List<Job> saveOrUpdate(List<Job> jobs) {
        
        List<Job> res = new ArrayList<>(); 
        
        jobs.stream().forEach((req) -> {
            
            // JOB 
            Job job = jobDao.saveOrUpdate(req);
            
            // JOB_DETAIL 
            JobDetail jobDetail = jobDetailSvc.saveJobDetail(JobDetail.prepare(job, req.getJobDetail()));
            
            res.add(Job.prepare(job, jobDetail));
        });
        
        return res;
    }
    
    
    
}
