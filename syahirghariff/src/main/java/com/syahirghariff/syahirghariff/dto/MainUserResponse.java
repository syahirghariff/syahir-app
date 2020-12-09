/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.syahirghariff.syahirghariff.dto;

/**
 *
 * @author syahirghariff
 */
public class MainUserResponse {
    
    private String userToken; 
    private String role; 
    
    public MainUserResponse(){
    }
    
    public MainUserResponse(String usertoken, String role) {
        this.userToken = usertoken; 
        this.role = role;
    }
    
    public MainUserResponse(String role){
    
        this.role = role;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "MainUserResponse{" + "userToken=" + userToken + ", role=" + role + '}';
    }
    
}
