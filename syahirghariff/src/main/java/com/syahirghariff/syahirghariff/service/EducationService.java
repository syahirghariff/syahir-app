/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.service;

import com.syahirghariff.syahirghariff.entity.Education;
import java.util.List;

/**
 *
 * @author syahirghariff
 */
public interface EducationService {

    public List<Education> findAll();
    
    public boolean deleteById (String id);
    
    public List<Education> display();

    public Education findById(String id);

    public List <Education> saveOrUpdate(List<Education> educations);

}
