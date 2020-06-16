/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.dao;

import com.syahirghariff.syahirghariff.entity.LoginTrx;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author syahirghariff
 */
@Repository
public class LoginTrxDao {
    
    @Autowired
    private EntityManager em;
    
    
    public LoginTrx saveOrUpdate(LoginTrx req) {

        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(req);

        return req; 
    }
}
