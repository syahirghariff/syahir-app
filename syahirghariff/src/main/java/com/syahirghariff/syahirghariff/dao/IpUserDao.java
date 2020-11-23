/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.dao;

import com.syahirghariff.syahirghariff.entity.IpUser;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author syahirghariff
 */
@Repository
public class IpUserDao {
    
    @Autowired
    private EntityManager em;
    
    public IpUser create (IpUser req) {
        
        IpUser ipUser = IpUser.create(req);
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(ipUser);

        return ipUser;
    
    }
    
    public List<IpUser> findAll() {
    
        Session session = em.unwrap(Session.class);
        Query<IpUser> query  = session.createQuery("from IpUser ", IpUser.class);
        return query.getResultList(); 
    }
    
}
