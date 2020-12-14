/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.serviceimpl;

import com.syahirghariff.syahirghariff.dao.EducationDao;
import com.syahirghariff.syahirghariff.entity.Education;
import com.syahirghariff.syahirghariff.service.EducationService;
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
public class EducationServiceImpl implements EducationService {

    @Autowired
    private EducationDao educationDao;

    @Override
    @Transactional
    public List<Education> findAll() {
        return Education.load(educationDao.findAll());
    }

    @Override
    @Transactional
    public Education findById(String id) {
        return educationDao.findById(id);
    }

    @Override
    @Transactional
    public List<Education> saveOrUpdate(List<Education> req) {
        List<Education> res = new ArrayList<>();

        req.stream().forEach((education) -> {

            // Validation name 
            if (education.getName() == null) {
                return;
            }

            // Presist
            res.add(educationDao.saveOrUpdate(education));

        });

        return res;
    }

    @Override
    public List<Education> display() {
        return Education.display(educationDao.display());
    }
    
    

    @Override
    @Transactional
    public boolean deleteById(String id) {

        Education education = educationDao.findById(id);

        if (education != null) {
            educationDao.deleteById(id);
            return true;
        }
        
        return false;
    }

}
