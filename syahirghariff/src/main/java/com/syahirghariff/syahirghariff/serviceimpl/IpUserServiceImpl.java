/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.serviceimpl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Base64;
import com.syahirghariff.syahirghariff.dao.IpUserDao;
import com.syahirghariff.syahirghariff.dto.Constants;
import com.syahirghariff.syahirghariff.dto.Ip;
import com.syahirghariff.syahirghariff.entity.IpUser;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import com.syahirghariff.syahirghariff.service.IpUserService;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author syahirghariff
 */
@Service
public class IpUserServiceImpl implements IpUserService {

    @Autowired
    private IpUserDao ipUserDao;

    @Override
    @Transactional
    public void getUserIp() {

        try {

            StringBuilder result = new StringBuilder();

            URL url = new URL(Constants.IP_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line;

            while ((line = rd.readLine()) != null) {
                result.append(line);
            }
            rd.close();

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            IpUser ipUser = objectMapper.readValue(result.toString(), IpUser.class);
            this.save(ipUser);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    @Transactional
    public IpUser save(IpUser ipUser) {
        return ipUserDao.create(ipUser);
    }

    @Override
    public List<Ip> findAll() {

        List<Ip> result = new ArrayList<>();

        ipUserDao.findIpList().stream().forEach((ipUser) -> {
            result.add(Ip.load(ipUser));
        });

        return result;
    }

    @Override
    public void set(String req) {

        try {
            String content = new String(Base64.getDecoder().decode(req));

            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            IpUser ipUser = objectMapper.readValue(content, IpUser.class);
            this.save(ipUser);

            System.out.println("Conten:" + ipUser.toString());
        } catch (Exception ex) {
            Logger.getLogger(IpUserServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
