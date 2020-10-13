/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.serviceimpl;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.syahirghariff.syahirghariff.dto.Ip;
import com.syahirghariff.syahirghariff.service.IPService;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.springframework.stereotype.Service;

/**
 *
 * @author syahirghariff
 */
@Service
public class IPServiceImpl implements IPService {
    
    private static final String IP_API_URL = "https://ipapi.co/json/";

    @Override
    public void getUserIp() {

        try {
            
            StringBuilder result = new StringBuilder();
            
            URL url = new URL(IP_API_URL);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            String line; 
            
            while ( (line=rd.readLine()) != null ){
                result.append(line);
            }
            rd.close();
            
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            Ip ip = objectMapper.readValue(result.toString(), Ip.class);
            System.out.println("Syahir test result: " + ip.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
