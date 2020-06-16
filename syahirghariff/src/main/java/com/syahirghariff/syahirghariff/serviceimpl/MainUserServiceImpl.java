/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.serviceimpl;

import com.syahirghariff.syahirghariff.dao.MainUserDao;
import com.syahirghariff.syahirghariff.dto.MainUserResponse;
import com.syahirghariff.syahirghariff.entity.MainUser;
import com.syahirghariff.syahirghariff.service.LoginTrxService;
import com.syahirghariff.syahirghariff.service.MainUserService;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 *
 * @author syahirghariff
 */
@Service
public class MainUserServiceImpl implements MainUserService {

    @Autowired
    private MainUserDao mainUserDao;

    @Autowired
    private LoginTrxService loginTrxSvc;

    @Override
    @Transactional
    public MainUserResponse doLogin(MainUser req) {
        
        MainUserResponse res = new MainUserResponse(false);

        if (req.getUsername() != null && req.getPassword() != null) {
            String username = req.getUsername().toLowerCase().trim();
            String password = req.getPassword().trim();

            
            // Find MainUser 
            MainUser user = this.findUser(username);

            if (user != null) {
                boolean isPasswordCorrect = BCrypt.checkpw(password, user.getPassword());

                if (isPasswordCorrect) {
                    return new MainUserResponse(this.generateToken(user), true);
                } else {
                    loginTrxSvc.createTrx(username, password);
                }

            } else {
                loginTrxSvc.createTrx(username, password);
            }

        }

        return res;
    }

    @Override
    @Transactional
    public MainUser findUser(String username) {
        return mainUserDao.findUser(username);
    }

    @Override
    @Transactional
    public boolean authenticate(String token) {
        return mainUserDao.authenticate(token);
    }
    
    
    
    private String generateToken(MainUser req) {
        
        try {
            // Combine username, password, date
            String concateString = req.getUsername().concat(req.getPassword()).concat(new Date().toString());
            
            // Convert to Base64
            String encodeString = Base64.getEncoder().encodeToString(concateString.getBytes());
            
            // Convert to Byte UTF-8
            byte[] bytes = encodeString.getBytes();
            
            // Generate SHA-256 bytes
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(bytes);
            
            byte[] result = md.digest();
            
            // Convert Hex String 
            String checksum = DatatypeConverter.printHexBinary(result);
            req.setToken(checksum);
            
            mainUserDao.saveOrUpdate(req);
            
            return req.getToken();
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(MainUserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

}
