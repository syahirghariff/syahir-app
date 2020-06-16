/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.dao;

import com.syahirghariff.syahirghariff.entity.Profile;
import com.syahirghariff.syahirghariff.serviceimpl.ProfileServiceImpl;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.sql.rowset.serial.SerialBlob;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author syahirghariff
 */
@Repository
public class ProfileDao {

    @Autowired
    private EntityManager em;

    public Profile saveOrUpdate(Profile req) {

        Profile profile = new Profile();
        profile.setActive(req.getActive());
        profile.setInsertDate(new Date());
        profile.setName(req.getName().trim());
        profile.setType(req.getType().trim());
            
        // If id is null
        if (req.getId() == null) {
            profile.setId(UUID.randomUUID().toString());
        } else {
            profile.setId(req.getId());
        }

        // If profile image
        if (req.getEncodeImg() != null) {
            try {
                byte[] decodeByte = Base64.getDecoder().decode(req.getEncodeImg());
                Blob blob = new SerialBlob(decodeByte);
                profile.setImage(blob);
                profile.setEncodeImg(req.getEncodeImg());
            } catch (SQLException ex) {
                Logger.getLogger(ProfileServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        // If svg
        if (req.getSvg() != null) {
            profile.setSvg(req.getSvg().trim());
        }
        

        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(profile);

        return profile;
    }
    
    public List<Profile> findAll() {
        
        CriteriaBuilder cb = em.getCriteriaBuilder(); 
        CriteriaQuery<Profile> cq = cb.createQuery(Profile.class);
        Root<Profile> from = cq.from(Profile.class);
        
        cq.select(from);
        
        TypedQuery<Profile> tq = em.createQuery(cq);
        return tq.getResultList();
    }

}
