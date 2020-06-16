/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.rest;

import com.syahirghariff.syahirghariff.entity.Profile;
import com.syahirghariff.syahirghariff.service.ProfileService;
import com.syahirghariff.syahirghariff.util.RespUtil;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author syahirghariff
 */
@RestController
@RequestMapping("/profile")
public class ProfileRestController {

    @Autowired
    private ProfileService profileSvc;
    
    @PostMapping("/do_submit")
    public ResponseEntity doSubmit(@RequestBody List<Profile> req) {
        
        List<Profile> res = profileSvc.saveOrUpdate(req);

        if (res != null) {
            return RespUtil.successResponse(res);
        } else {
            return RespUtil.successResponse(false);
        }
    }
    
    
    @GetMapping("/find_all")
    public ResponseEntity findAll() {
        return RespUtil.successResponse(profileSvc.findAll());
    }

}
