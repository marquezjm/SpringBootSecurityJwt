/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kiubit.kiubitWebAPI.controller;

import com.kiubit.kiubitWebAPI.pojos.AuthenticationRequest;
import com.kiubit.kiubitWebAPI.pojos.AuthenticationResponse;
import com.kiubit.kiubitWebAPI.pojos.EntityResponse;
import com.kiubit.kiubitWebAPI.pojos.Usuario;
import com.kiubit.kiubitWebAPI.security.JWTTokenUtil;
import com.kiubit.kiubitWebAPI.security.SecurityPrincipal;
import com.kiubit.kiubitWebAPI.service.UsuarioService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DesarrolloDB
 */
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/user")
@SecurityRequirement(name = "Bearer Authentication")
public class UserController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    UsuarioService userService;

    @Autowired
    private JWTTokenUtil jwtTokenUtil;

    @Autowired
    PasswordEncoder passwordEncoder;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<Object> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
            throws Exception {

        try {
            authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
        } catch (Exception e) {
            return EntityResponse.generateResponse("Authentication Failed", HttpStatus.OK,
                    "Invalid credentials, please check details and try again.");
        }
        final UserDetails userDetails = userService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);
        final String refreshToken = jwtTokenUtil.generateRefreshToken(userDetails);

        return EntityResponse.generateResponse("Authentication", HttpStatus.OK,
                new AuthenticationResponse(token, refreshToken));

    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }catch (Exception e){
            throw new Exception("Error", e);
        }
    }

    @GetMapping("/is-authenticated")
    @ResponseBody
    public ResponseEntity<Object> isUserAuthenticated() {
        Usuario principal = SecurityPrincipal.getInstance().getLoggedInPrincipal();
        if (principal != null) {
            return EntityResponse.generateResponse("Authenticated", HttpStatus.OK, true);
        }
        return EntityResponse.generateResponse("Unauthorized", HttpStatus.OK, false);
    }

    @GetMapping("/registered")
    @ResponseBody
    public ResponseEntity<Object> isUserRegistered(@RequestParam("username") String username) {
        if (userService.findByUsername(username) != null) {
            return EntityResponse.generateResponse("Registered", HttpStatus.OK, true);
        }
        return EntityResponse.generateResponse("Registered", HttpStatus.OK, false);
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Object> getUser() {
        Usuario user = userService.findByUsername(SecurityPrincipal.getInstance().getLoggedInPrincipal().getCorreo());
        return EntityResponse.generateResponse("Retrieve User Success", HttpStatus.OK, user);
    }

    @PostMapping("/register")
    @ResponseBody
    public ResponseEntity<Object> createUser(@RequestBody Usuario user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        String response = userService.createUser(user);

        return EntityResponse.generateResponse("Create", HttpStatus.CREATED, response);

    }
    
    @PostMapping("/get-user")
    @ResponseBody
    public ResponseEntity<Object> getUser(@RequestBody Usuario usuario) {
        Usuario user = userService.findByUsername(usuario.getCorreo());
        return EntityResponse.generateResponse("Retrieve User Success", HttpStatus.OK, user);
    }

    /*@PostMapping("/user-role")
    @ResponseBody
    public void createUserRoel(@RequestBody Role param) {
        try {
            userService.addUserRoleByUsernameAndRoleName(param);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/
}
