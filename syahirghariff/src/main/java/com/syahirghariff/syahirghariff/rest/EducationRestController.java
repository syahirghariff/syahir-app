/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.rest;

import com.syahirghariff.syahirghariff.dto.Constants;
import com.syahirghariff.syahirghariff.entity.Education;
import com.syahirghariff.syahirghariff.service.EducationService;
import com.syahirghariff.syahirghariff.service.MainUserService;
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
@RequestMapping("/education")
public class EducationRestController {

    @Autowired
    private EducationService educationSvc;

    @Autowired
    private MainUserService mainUserSvc;

    @GetMapping("/find_all")
    public ResponseEntity findAll() {
        return RespUtil.successResponse(educationSvc.findAll());
    }

    @PostMapping("/do_submit")
    public ResponseEntity doSubmit(@RequestHeader(value = Constants.AUTHORIZATION) String auth, @RequestBody List<Education> req) {

        if (!mainUserSvc.authenticate(auth)) {
            return RespUtil.unauthorized();
        }

        return RespUtil.successResponse(educationSvc.saveOrUpdate(req));
    }

    @PostMapping("/delete_by_id")
    public ResponseEntity deleteById(@RequestHeader(value = Constants.AUTHORIZATION) String auth, @RequestBody String id) {
        
        if (!mainUserSvc.authenticate(auth)) {
            return RespUtil.unauthorized();
        }

        ResponseEntity responseEntity = educationSvc.deleteById(id)
                ? RespUtil.successResponse(educationSvc.findAll())
                : RespUtil.notFound("Education with id of " + id + " cannot be found");

        return responseEntity;
    }

}
