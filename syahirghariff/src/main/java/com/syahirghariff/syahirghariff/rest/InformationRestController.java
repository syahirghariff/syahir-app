/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.rest;

import com.syahirghariff.syahirghariff.service.InformationService;
import com.syahirghariff.syahirghariff.util.RespUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author syahirghariff
 */
@RestController
@RequestMapping("/info")
public class InformationRestController {
    
    @Autowired
    private InformationService infoSvc;
    
    @GetMapping("/display")
    public ResponseEntity getDisplay() {
        return RespUtil.successResponse(infoSvc.getDisplay());
    }
    
}
