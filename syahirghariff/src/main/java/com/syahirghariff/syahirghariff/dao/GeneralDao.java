/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.dao;

import com.syahirghariff.syahirghariff.entity.General;
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
public class GeneralDao {
    
    @Autowired
    private EntityManager em;
    
    public General saveOrUpdate(General req){
        
        General general = General.create(req); 
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(general);
        
        return general;
    }
    
    public List<General> findAll() {

        Session session = em.unwrap(Session.class);

        Query<General> query = session.createQuery("from General ", General.class);

        return query.getResultList();
    }
    
    public General findByCode(String code){
        Session session = em.unwrap(Session.class);

        Query<General> query = session.createQuery("from General where code=:code", General.class);
        query.setParameter("code", code);
        
        List<General> results = query.getResultList();
        
        if (!results.isEmpty()) {
            return results.get(0);
        }
        
        return null;
    }
    
}
