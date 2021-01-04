/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.rest;

import com.syahirghariff.syahirghariff.dto.Constants;
import com.syahirghariff.syahirghariff.service.GeneralService;
import com.syahirghariff.syahirghariff.service.IpUserService;
import com.syahirghariff.syahirghariff.util.RespUtil;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author syahirghariff
 */
@RestController
@RequestMapping("/test")
public class TestController {
    
    @Autowired
    private IpUserService ipUserSvc;
    
    @Autowired
    private GeneralService generalSvc;
    
    @GetMapping("/testing")
    public ResponseEntity testAll (@RequestHeader (value="Authorization") String test, @RequestBody String test1){
        
        System.out.println("TEST: " + test);
        System.out.println("TEST: " + Constants.IP_URL);
        
        ipUserSvc.getUserIp();
        return RespUtil.successResponse(System.getProperty("user.dir"));
    }
    
    @GetMapping("/api")
    public ResponseEntity getTest() {
        return RespUtil.successResponse(new ArrayList<>());
    }
    
}
