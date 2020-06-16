/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.util;

import java.util.HashMap;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author syahirghariff
 */
public class RespUtil {
   
    public RespUtil() {
    }
    
    
    public static ResponseEntity successResponse(Object content){
        
        Map res = new HashMap<>();
        res.put("status", HttpStatus.OK);
        res.put("content", content); 
        
        return ResponseEntity.ok(res);
    }
    
}
