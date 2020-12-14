/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.rest;

import com.syahirghariff.syahirghariff.dto.Constants;
import com.syahirghariff.syahirghariff.entity.Profile;
import com.syahirghariff.syahirghariff.service.MainUserService;
import com.syahirghariff.syahirghariff.service.ProfileService;
import com.syahirghariff.syahirghariff.util.RespUtil;
import java.util.List;
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
@RequestMapping("/profile")
public class ProfileRestController {

    @Autowired
    private ProfileService profileSvc;

    @Autowired
    private MainUserService mainUserSvc;

    @PostMapping("/do_submit")
    public ResponseEntity doSubmit(@RequestHeader(value = Constants.AUTHORIZATION) String auth, @RequestBody List<Profile> req) {

        if (!mainUserSvc.authenticate(auth)) {
            return RespUtil.unauthorized();
        }

        return RespUtil.successResponse(profileSvc.saveOrUpdate(req));
    }

    @GetMapping("/find_all")
    public ResponseEntity findAll() {
        return RespUtil.successResponse(profileSvc.findAll());
    }
    
    @GetMapping("/display")
    public ResponseEntity display() {
        return RespUtil.successResponse(profileSvc.display());
    }

    @PostMapping("/delete_by_id")
    public ResponseEntity deleteById(@RequestHeader(value = Constants.AUTHORIZATION) String auth, @RequestBody String id) {

        if (!mainUserSvc.authenticate(auth)) {
            return RespUtil.unauthorized();
        }

        ResponseEntity responseEntity = profileSvc.deleteById(id)
                ? RespUtil.successResponse(profileSvc.findAll())
                : RespUtil.notFound("Profile with id of " + id + " cannot be found");

        return responseEntity;
    }

}
