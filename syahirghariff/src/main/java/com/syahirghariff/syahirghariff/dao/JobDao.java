/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.dao;

import com.syahirghariff.syahirghariff.entity.Job;
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
public class JobDao {
    
    @Autowired
    private EntityManager em;
    
    public Job saveOrUpdate(Job req) {

        Job job = Job.create(req);
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(job);

        return job;
    }
    
    public List<Job> findAll () {
        Session session = em.unwrap(Session.class);

        Query<Job> query = session.createQuery("from Job", Job.class);

        return query.getResultList();
    }
    
    public Job findById (String id) {
        Session session = em.unwrap(Session.class);

        Query<Job> query = session.createQuery("from Job where id = :id", Job.class);
        query.setParameter("id", id);

        List <Job> result = query.getResultList(); 
        
        if (!result.isEmpty()) {
            return result.get(0);
        }
        
        return null;
    
    }
    
    public void deleteById(String id) {
        Session currentSession = em.unwrap(Session.class); 
        
        Query query = currentSession.createQuery("delete from Job where id=:id"); 
        query.setParameter("id", id);
        
        query.executeUpdate();
    }
    
    
}
