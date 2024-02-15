/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kiubit.kiubitWebAPI.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author DesarrolloDB
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuarioDTO {

    private String usuario_id;
    private String password;
    private String alias;
    private String nombre;
    private String apellido_paterno;
    private String apellido_materno;
    private String correo;
}
