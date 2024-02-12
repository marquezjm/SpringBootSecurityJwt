/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kiubit.kiubitWebAPI.controller;

import com.kiubit.kiubitWebAPI.interfaces.Respuesta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author HP
 */
@Controller
@RequestMapping(path = "",produces = MediaType.APPLICATION_JSON_VALUE)
public class HomeController {
    
    @Operation(summary = "Demo Map", description = "Demo Map")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping(path = "hola-mundo")
    public ResponseEntity<Respuesta> holaMundo(){    
        Respuesta respuesta = new Respuesta();
        respuesta.setRespuesta("Hola Mundo");
        return ResponseEntity.ok().body(respuesta);
    }
}


