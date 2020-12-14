/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.dao;

import com.syahirghariff.syahirghariff.entity.Education;
import com.syahirghariff.syahirghariff.entity.Education_;
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
public class EducationDao{
    
    @Autowired
    private EntityManager em;

    public List<Education> findAll() {

        Session session = em.unwrap(Session.class);

        Query<Education> query = session.createQuery("from Education", Education.class);

        return query.getResultList();
    }
    
    public List<Education> display () {
    
        Session session = em.unwrap(Session.class);
        
        Query<Education> query = session.createQuery("from Education where active='A' order by insertDate asc", Education.class);
        
        return query.getResultList();
    
    }
    
    public Education saveOrUpdate(Education req) {

        Education education = Education.create(req);
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(education);

        return education;
    }
    
    public void deleteById(String id) {
        Session currentSession = em.unwrap(Session.class); 
        
        Query query = currentSession.createQuery("delete from Education where id=:id"); 
        query.setParameter("id", id);
        
        query.executeUpdate();
    }
    
    public Education findById (String id) {
        
        CriteriaBuilder cb = em.getCriteriaBuilder(); 
        CriteriaQuery<Education> cq = cb.createQuery(Education.class);
        Root<Education> from = cq.from(Education.class);
        Predicate pred = cb.equal(from.get(Education_.id), id);
        
        cq.select(from).where(pred);
        
        TypedQuery<Education> tq = em.createQuery(cq);
        
        List<Education> res = tq.getResultList(); 
        
        if (!res.isEmpty()){
            return res.get(0);
        }
        
        return null;
    
    }

}
