/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.serviceimpl;

import com.syahirghariff.syahirghariff.dao.ProfileDao;
import com.syahirghariff.syahirghariff.entity.Profile;
import com.syahirghariff.syahirghariff.service.MainUserService;
import com.syahirghariff.syahirghariff.service.ProfileService;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author syahirghariff
 */
@Service
public class ProfileServiceImpl implements ProfileService {

    @Autowired
    private MainUserService mainUserSvc;

    @Autowired
    private ProfileDao profileDao;

    @Override
    @Transactional
    public List<Profile> saveOrUpdate(List<Profile> req) {

        String token = req.get(0).getToken();

        // Validation token 
        if (mainUserSvc.authenticate(token)) {

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
        } else {
            return null;
        }
    }

    @Override
    public List<Profile> findAll() {

        List<Profile> res = new ArrayList<>();

        profileDao.findAll().stream().forEach(profile -> {

            try {
                if (profile.getImage() != null) {

                    Blob image = profile.getImage();
                    byte[] bytes = image.getBytes(1, (int) image.length());
                    
                    String encodedImage = Base64.encodeBase64String(bytes);
                    profile.setEncodeImg(encodedImage);
                    image.free();
                }
            } catch (SQLException ex) {
                Logger.getLogger(ProfileServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }

            res.add(profile);
        });
        return res;
    }

}
