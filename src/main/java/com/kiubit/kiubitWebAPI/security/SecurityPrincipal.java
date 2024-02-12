/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kiubit.kiubitWebAPI.security;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
public class SecurityPrincipal {
    private static SecurityPrincipal securityPrincipal = null;

    private Authentication principal = SecurityContextHolder.getContext().getAuthentication();

    private static WUserService userService;


    @Autowired	
    private SecurityPrincipal(WUserService userService) {
            this.userService = userService;
    }


    public static SecurityPrincipal getInstance() {
            securityPrincipal = new SecurityPrincipal(userService);
            return securityPrincipal;
    }

    public User getLoggedInPrincipal() {
            if(principal != null) {
                    UserDetails loggedInPrincipal = (UserDetails) principal.getPrincipal();
                    return userService.findByUsername(loggedInPrincipal.getUsername());
            }
            return null;
    }

    public Collection<?> getLoggedInPrincipalAuthorities() {
            return ((UserDetails)principal.getPrincipal()).getAuthorities();
    }
}
