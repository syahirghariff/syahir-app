/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.dao;

import com.syahirghariff.syahirghariff.entity.Profile;
import com.syahirghariff.syahirghariff.entity.Profile_;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
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

        Profile profile = Profile.create(req);
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
    
    public List<Profile> display() {
        
       Session currentSession = em.unwrap(Session.class); 
       
       Query query = currentSession.createQuery("from Profile where active='A'");
       
       return query.getResultList();
    
    }
    
    public void deleteById (String id) {
        
        Session currentSession = em.unwrap(Session.class); 
        
        Query query = currentSession.createQuery("delete from Profile where id=:id"); 
        query.setParameter("id", id);
        
        query.executeUpdate();
    }
    
    public Profile findById (String id) {
        
        CriteriaBuilder cb = em.getCriteriaBuilder(); 
        CriteriaQuery<Profile> cq = cb.createQuery(Profile.class);
        Root<Profile> from = cq.from(Profile.class);
        Predicate pred = cb.equal(from.get(Profile_.id), id);
        
        cq.select(from).where(pred);
        
        TypedQuery<Profile> tq = em.createQuery(cq);
        
        List<Profile> res = tq.getResultList(); 
        
        if (!res.isEmpty()){
            return res.get(0);
        }
        
        return null;
    
    }

}
