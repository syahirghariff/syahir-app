/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.dao;

import com.syahirghariff.syahirghariff.entity.IpUser;
import com.syahirghariff.syahirghariff.entity.IpUser_;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
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
public class IpUserDao {

    @Autowired
    private EntityManager em;

    public IpUser create(IpUser req) {

        IpUser ipUser = IpUser.create(req);
        Session session = em.unwrap(Session.class);
        session.saveOrUpdate(ipUser);

        return ipUser;

    }

    public List<IpUser> findAll() {

        Session session = em.unwrap(Session.class);
        Query<IpUser> query = session.createQuery("from IpUser ", IpUser.class);
        return query.getResultList();
    }

    public List<IpUser> findIpList() {

        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery cq = cb.createQuery(IpUser.class);
        Root<IpUser> root = cq.from(IpUser.class);

        cq.multiselect(
                root.get(IpUser_.ip), root.get(IpUser_.city), root.get(IpUser_.country), root.get(IpUser_.insertDate),
                root.get(IpUser_.internetProvider), root.get(IpUser_.latitude), root.get(IpUser_.longitude), 
                root.get(IpUser_.postal), root.get(IpUser_.region)
        ).distinct(true);

        TypedQuery<IpUser> query = em.createQuery(cq);

        return query.getResultList();
    }
}
