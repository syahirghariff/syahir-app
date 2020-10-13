/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.dao;

import com.syahirghariff.syahirghariff.entity.Tech;
import com.syahirghariff.syahirghariff.entity.Tech_;
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
public class TechDao {
    
    @Autowired
    private EntityManager em;
    
    
    public Tech saveOrUpdate (Tech req){
        
        Tech tech =  Tech.create(req);
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(tech);
        
        return tech;
    }
    
    public Tech findById (String id) {
        
        CriteriaBuilder cb = em.getCriteriaBuilder(); 
        CriteriaQuery<Tech> cq = cb.createQuery(Tech.class);
        Root<Tech> from = cq.from(Tech.class);
        Predicate pred = cb.equal(from.get(Tech_.id), id);
        
        cq.select(from).where(pred);
        
        TypedQuery<Tech> tq = em.createQuery(cq);
        
        List<Tech> res = tq.getResultList(); 
        
        if (!res.isEmpty()){
            return res.get(0);
        }
        
        return null;
    
    }
    
    public void deleteById(String id) {
        Session currentSession = em.unwrap(Session.class); 
        
        Query query = currentSession.createQuery("delete from Tech where id=:id"); 
        query.setParameter("id", id);
        
        query.executeUpdate();
    }
    
    public List<Tech> findAll() {

        Session session = em.unwrap(Session.class);

        Query<Tech> query = session.createQuery("from Tech order by seq asc", Tech.class);

        return query.getResultList();
    }
}
