/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kiubit.kiubitWebAPI.pojos;

/**
 *
 * @author DesarrolloDB
 */
public class AuthenticationResponse {

    private String token;
    private String refresh;

    public AuthenticationResponse(String token) {
        this.token = token;
        this.refresh = null;
    }

    public AuthenticationResponse(String token, String refresh) {
        this.token = token;
        this.refresh = refresh;
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * @return the refresh
     */
    public String getRefresh() {
        return refresh;
    }

    /**
     * @param refresh the refresh to set
     */
    public void setRefresh(String refresh) {
        this.refresh = refresh;
    }
}
