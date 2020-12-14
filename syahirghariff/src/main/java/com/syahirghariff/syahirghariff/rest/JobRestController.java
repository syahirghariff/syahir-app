/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.rest;

import com.syahirghariff.syahirghariff.dto.Constants;
import com.syahirghariff.syahirghariff.entity.Job;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.syahirghariff.syahirghariff.service.JobService;
import com.syahirghariff.syahirghariff.service.MainUserService;
import com.syahirghariff.syahirghariff.util.RespUtil;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

/**
 *
 * @author syahirghariff
 */
@RestController
@RequestMapping("/job")
public class JobRestController {

    @Autowired
    private JobService jobSvc;

    @Autowired
    private MainUserService mainUserSvc;

    @PostMapping("/do_submit")
    public ResponseEntity doSubmit(@RequestHeader(value = Constants.AUTHORIZATION) String auth, @RequestBody List<Job> req) {

        if (!mainUserSvc.authenticate(auth)) {
            return RespUtil.unauthorized();
        }

        return RespUtil.successResponse(jobSvc.saveOrUpdate(req));
    }

    @GetMapping("/find_all")
    public ResponseEntity findAll() {

        return RespUtil.successResponse(jobSvc.findAll());
    }
    
    @GetMapping("/display")
    public ResponseEntity display() {

        return RespUtil.successResponse(jobSvc.display());
    }

    @PostMapping("/delete_by_id")
    public ResponseEntity deleteById(@RequestHeader(value = Constants.AUTHORIZATION) String auth, @RequestBody String id) {

        if (!mainUserSvc.authenticate(auth)) {
            return RespUtil.unauthorized();
        }

        ResponseEntity responseEntity = jobSvc.deleteById(id)
                ? RespUtil.successResponse(jobSvc.findAll())
                : RespUtil.notFound("Job with id of " + id + " cannot be found");

        return responseEntity;
    }

}
