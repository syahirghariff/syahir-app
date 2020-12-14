/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.serviceimpl;

import com.syahirghariff.syahirghariff.dto.Information;
import com.syahirghariff.syahirghariff.entity.Education;
import com.syahirghariff.syahirghariff.entity.Job;
import com.syahirghariff.syahirghariff.entity.Profile;
import com.syahirghariff.syahirghariff.entity.Tech;
import com.syahirghariff.syahirghariff.service.EducationService;
import com.syahirghariff.syahirghariff.service.InformationService;
import com.syahirghariff.syahirghariff.service.IpUserService;
import com.syahirghariff.syahirghariff.service.JobService;
import com.syahirghariff.syahirghariff.service.ProfileService;
import com.syahirghariff.syahirghariff.service.TechService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author syahirghariff
 */
@Service
public class InformationServiceImpl implements InformationService {
    
    @Autowired
    private IpUserService ipUserSvc;
    
    @Autowired
    private ProfileService profileSvc;
    
    @Autowired
    private EducationService eduSvc;
    
    @Autowired
    private TechService techSvc;
    
    @Autowired
    private JobService jobSvc;

    @Override
    public Information getDisplay() {
        
        // Get IP of user 
        ipUserSvc.getUserIp();
        
        // PROFILE
        List<Profile> profiles = profileSvc.display();
        
        // EDUCATION
        List<Education> educations = eduSvc.display(); 
        
        // TECH
        List<Tech> techs = techSvc.display();
        
        // JOB
        List<Job> jobs = jobSvc.display();
        
        return new Information(profiles, educations, techs, jobs);
    }
    
    
    
}
