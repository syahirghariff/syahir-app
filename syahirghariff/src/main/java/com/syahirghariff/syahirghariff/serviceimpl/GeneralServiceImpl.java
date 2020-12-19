/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.serviceimpl;

import com.syahirghariff.syahirghariff.dao.GeneralDao;
import com.syahirghariff.syahirghariff.entity.General;
import com.syahirghariff.syahirghariff.service.GeneralService;
import java.io.FileOutputStream;
import java.util.Base64;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author syahirghariff
 */
@Service
public class GeneralServiceImpl implements GeneralService {
    
    // Development
    //public static final String SVG_FILEPATH = System.getProperty("user.home")+"/workspace/syahir-web/src/assets/sprite.svg";
    
    //Production 
    public static final String SVG_FILEPATH = System.getProperty("user.home")+"web/assets/sprite.svg";

    @Autowired
    private GeneralDao generalDao;

    @Override
    @Transactional
    public General saveOrUpdate(General req) {

        General general = generalDao.saveOrUpdate(req);

        switch (general.getCode()) {

            case "SVG":
                this.generateSvgFile(general.getDesc());
                break;
        }

        return general;
    }

    @Override
    @Transactional
    public List<General> findAll() {
        return generalDao.findAll();
    }

    @Override
    public General findByCode(String code) {
        return generalDao.findByCode(code);
    }
    
    private void generateSvgFile(String base64Svg) {

        try {

            // Content 
            byte svg_bytes[] = Base64.getDecoder().decode(base64Svg);
            String svg_string = new String(svg_bytes);

            // Generate File 
            FileOutputStream outputStream = new FileOutputStream(SVG_FILEPATH);
            byte b[] = svg_string.getBytes();//converting string into byte array    
            outputStream.write(b);
            outputStream.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
