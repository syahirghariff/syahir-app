/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.serviceimpl;

import com.syahirghariff.syahirghariff.dao.MainUserDao;
import com.syahirghariff.syahirghariff.dto.Constants;
import com.syahirghariff.syahirghariff.dto.MainUserResponse;
import com.syahirghariff.syahirghariff.entity.MainUser;
import com.syahirghariff.syahirghariff.enums.StatusEnum;
import com.syahirghariff.syahirghariff.service.IpUserService;
import com.syahirghariff.syahirghariff.service.LoginTrxService;
import com.syahirghariff.syahirghariff.service.MainUserService;
import com.syahirghariff.syahirghariff.util.RespUtil;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.transaction.Transactional;
import javax.xml.bind.DatatypeConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Autowired
    private IpUserService ipUserSvc;

    @Override
    @Transactional
    public ResponseEntity doLogin(MainUser req) {
        
        String username = req.getUsername().trim();
        String password = req.getPassword().trim();

        // Find MainUser 
        MainUser user = this.findUser(username);

        if (user != null && user.getActive().equals(StatusEnum.A)) {

            // Caclulat password 
            boolean isPasswordCorrect = BCrypt.checkpw(password, user.getPassword());

            if (isPasswordCorrect) {

                switch (user.getRole()) {
                
                    case "MASTER":
                        return RespUtil.successResponse(new MainUserResponse(this.generateToken(user), user.getRole()));
                        
                    default: 
                        loginTrxSvc.createTrx(username, password);
                        return RespUtil.successResponse(new MainUserResponse(user.getRole()));
                }
                

            } else {
                loginTrxSvc.createTrx(username, password);
                return RespUtil.unauthorized();
            }

        } else {
            loginTrxSvc.createTrx(username, password);
            return RespUtil.unauthorized();
        }
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
            String concateString = req.getUsername().concat(req.getPassword()).concat(new Date().toString()).concat(Constants.COBALT_BLUE);

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
