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
    private boolean login; 

    public MainUserResponse(String userToken, boolean login) {
        this.userToken = userToken;
        this.login = login;
    }
    
    public MainUserResponse(boolean login){
        this.login = login;
    }
    
    public MainUserResponse(){
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public boolean isLogin() {
        return login;
    }

    public void setLogin(boolean login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "MainUserResponse{" + "userToken=" + userToken + ", login=" + login + '}';
    }
}
