/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.serviceimpl;

import com.syahirghariff.syahirghariff.dao.ProfileDao;
import com.syahirghariff.syahirghariff.entity.Profile;
import com.syahirghariff.syahirghariff.service.IpUserService;
import com.syahirghariff.syahirghariff.service.ProfileService;
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
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private ProfileDao profileDao;
    
    @Autowired
    private IpUserService ipUserSvc;

    @Override
    @Transactional
    public List<Profile> saveOrUpdate(List<Profile> req) {

        List<Profile> res = new ArrayList<>();

        req.stream().forEach((profile) -> {

            // Validation name 
            if (profile.getName() == null) {
                return;
            }

            // Validation type
            if (profile.getType() == null) {
                return;
            }

            // Presist
            res.add(profileDao.saveOrUpdate(profile));

        });

        return res;
    }

    @Override
    @Transactional
    public List<Profile> findAll() {
        return Profile.load(profileDao.findAll());
    }

    @Override
    public Profile findById(String id) {
        return profileDao.findById(id);
    }

    @Override
    public List<Profile> display() {
        ipUserSvc.getClass();
        return Profile.display(profileDao.display());
    }
    
    

    @Override
    @Transactional
    public boolean deleteById(String id) {

        Profile profile = this.findById(id);

        if (profile != null) {
            profileDao.deleteById(id);
            return true;
        }
        
        return false;

    }

}
