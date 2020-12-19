/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.rest;

import com.syahirghariff.syahirghariff.dto.Constants;
import com.syahirghariff.syahirghariff.entity.General;
import com.syahirghariff.syahirghariff.service.GeneralService;
import com.syahirghariff.syahirghariff.service.MainUserService;
import com.syahirghariff.syahirghariff.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author syahirghariff
 */
@RestController
@RequestMapping("/general")
public class GeneralRestController {
    
    @Autowired
    private GeneralService generalSvc;
    
    
    @Autowired
    private MainUserService mainUserSvc;
    
    
    @PostMapping("/do_submit")
    public ResponseEntity doSubmit(@RequestHeader(value = Constants.AUTHORIZATION) String auth, @RequestBody General req) {

        if (!mainUserSvc.authenticate(auth)) {
            return RespUtil.unauthorized();
        }

        return RespUtil.successResponse(generalSvc.saveOrUpdate(req));
    }
    
    @PostMapping("/get_by_code")
    public ResponseEntity getByCode(@RequestBody String code) {
        return RespUtil.successResponse(generalSvc.findByCode(code));
    }
    
    @GetMapping("/get_user_dir")
    public ResponseEntity getUserDir() {
        return RespUtil.successResponse(System.getProperty("user.home"));
    }
    
}
