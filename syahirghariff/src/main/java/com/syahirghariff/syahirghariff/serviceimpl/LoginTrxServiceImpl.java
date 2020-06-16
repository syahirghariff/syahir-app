/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.serviceimpl;

import com.syahirghariff.syahirghariff.dao.LoginTrxDao;
import com.syahirghariff.syahirghariff.entity.LoginTrx;
import com.syahirghariff.syahirghariff.service.LoginTrxService;
import java.util.Date;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author syahirghariff
 */
@Service
public class LoginTrxServiceImpl implements LoginTrxService {
    
    @Autowired
    private LoginTrxDao loginTrxDao; 

    @Override
    @Transactional
    public LoginTrx createTrx(String username, String password) {
        
        LoginTrx loginTrx = new LoginTrx();
        loginTrx.setId(UUID.randomUUID().toString());
        loginTrx.setUsername(username);
        loginTrx.setPassword(password);
        loginTrx.setInsertDate(new Date());
        
        return loginTrxDao.saveOrUpdate(loginTrx);
    }
    
    
    
}
