/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.rest;

import com.syahirghariff.syahirghariff.entity.MainUser;
import com.syahirghariff.syahirghariff.service.MainUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author syahirghariff
 */
@RestController
@RequestMapping("/user")
public class UserRestController {

    @Autowired
    private MainUserService mainUserSvc;

    @PostMapping("/do_login")
    public ResponseEntity doLogin(@RequestBody MainUser user) {
        return mainUserSvc.doLogin(user);
    }

}
