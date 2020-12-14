/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.dto;

import com.syahirghariff.syahirghariff.entity.Education;
import com.syahirghariff.syahirghariff.entity.Job;
import com.syahirghariff.syahirghariff.entity.Profile;
import com.syahirghariff.syahirghariff.entity.Tech;
import java.util.List;

/**
 *
 * @author syahirghariff
 */
public class Information {
    
    public List<Profile> profiles; 
    
    public List<Education> educations; 
    
    public List<Tech> techs; 
    
    public List<Job> experience; 
    
    public Information(){
    }
    
    public Information(List<Profile> profiles, List<Education> educations, List<Tech> techs, List<Job> experience) {
        
        this.profiles = profiles;
        this.educations = educations; 
        this.techs = techs;
        this.experience = experience;
    }

    public List<Profile> getProfiles() {
        return profiles;
    }

    public void setProfiles(List<Profile> profiles) {
        this.profiles = profiles;
    }

    public List<Education> getEducations() {
        return educations;
    }

    public void setEducations(List<Education> educations) {
        this.educations = educations;
    }

    public List<Tech> getTechs() {
        return techs;
    }

    public void setTechs(List<Tech> techs) {
        this.techs = techs;
    }

    public List<Job> getExperience() {
        return experience;
    }

    public void setExperience(List<Job> experience) {
        this.experience = experience;
    }

    @Override
    public String toString() {
        return "Display{" + "profiles=" + profiles + ", educations=" + educations + ", techs=" + techs + ", experience=" + experience + '}';
    }
    
    
}
