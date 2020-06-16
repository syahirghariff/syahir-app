/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.dao;

import com.syahirghariff.syahirghariff.entity.MainUser;
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
public class MainUserDao {

    @Autowired
    private EntityManager em;

    public MainUser findUser(String username) {

        Session session = em.unwrap(Session.class);

        Query<MainUser> query = session.createQuery("from MainUser where username = :username", MainUser.class);
        query.setParameter("username", username);

        List<MainUser> result = query.getResultList();

        if (!result.isEmpty()) {
            return query.getResultList().get(0);
        }

        return null;
    }
    
    public MainUser saveOrUpdate(MainUser req){
    
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(req);
        
        return req;
    }
    
    public boolean authenticate(String token) {
        Session session = em.unwrap(Session.class);
        
        Query<MainUser> query = session.createQuery("from MainUser where token = :token", MainUser.class); 
        query.setParameter("token", token);
        
        List<MainUser> result = query.getResultList();

        if (!result.isEmpty()) {
            return true;
        }

        return false;
        
    }

}

