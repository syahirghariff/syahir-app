/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.rest;

import com.syahirghariff.syahirghariff.dto.Constants;
import com.syahirghariff.syahirghariff.service.IpUserService;
import com.syahirghariff.syahirghariff.service.MainUserService;
import com.syahirghariff.syahirghariff.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author syahirghariff
 */
@RestController
@RequestMapping("/stats")
public class IpUserRestController {
    
    @Autowired
    private MainUserService mainUserSvc;
    
    @Autowired
    private IpUserService ipUserSvc;
    
    @GetMapping("/find_all")
    public ResponseEntity findAll(@RequestHeader(value = Constants.AUTHORIZATION) String auth) {

        if (!mainUserSvc.authenticate(auth)) {
            return RespUtil.unauthorized();
        }
        return RespUtil.successResponse(ipUserSvc.findAll());
    }
    
}
