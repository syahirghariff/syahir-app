/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.dao;

import com.syahirghariff.syahirghariff.entity.Job;
import com.syahirghariff.syahirghariff.entity.JobDetail;
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
public class JobDetailDao {
    
    @Autowired
    private EntityManager em;
    
    
    public JobDetail saveOrUpdate (JobDetail req) {
        
        JobDetail jobDetail = JobDetail.create(req);
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(jobDetail);
        
        return jobDetail;
    
    }
    
    public JobDetail findByJob (Job job) {
    
    
        Session session = em.unwrap(Session.class);
        
        Query<JobDetail> query = session.createQuery("from JobDetail where job = :job  ");
        query.setParameter("job", job);
        
        List<JobDetail> result = query.getResultList(); 
        
        if (!result.isEmpty()) {
            return result.get(0);
        }
        
        return null;
        
    }
    
    public void deleteById(String id) {
        Session currentSession = em.unwrap(Session.class); 
        
        Query query = currentSession.createQuery("delete from JobDetail where id=:id"); 
        query.setParameter("id", id);
        
        query.executeUpdate();
    }
    
}
