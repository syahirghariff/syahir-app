/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.serviceimpl;

import com.syahirghariff.syahirghariff.dao.TechDao;
import com.syahirghariff.syahirghariff.entity.Tech;
import com.syahirghariff.syahirghariff.service.TechService;
import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author syahirghariff
 */
@Service
public class TechServiceImpl implements TechService {

    @Autowired
    private TechDao techDao;

    @Override
    @Transactional
    public List<Tech> findAll() {
        return techDao.findAll();
    }

    @Override
    public List<Tech> display() {
        return Tech.display(techDao.display());
    }
    
    

    @Override
    @Transactional
    public List<Tech> saveOrUpdate(List<Tech> req) {
        List<Tech> res = new ArrayList<>();

        req.stream().forEach((tech) -> {

            // Validation name 
            if (tech.getName() == null) {
                return;
            }

            // Presist
            res.add(techDao.saveOrUpdate(tech));

        });

        return res;
    }

    @Override
    @Transactional
    public boolean deleteById(String id) {

        Tech tech = techDao.findById(id);

        if (tech != null) {
            techDao.deleteById(id);
            return true;
        }
        return false;
    }

}
