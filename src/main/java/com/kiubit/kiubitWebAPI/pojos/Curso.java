/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kiubit.kiubitWebAPI.pojos;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *
 * @author DesarrolloDB
 */

@Entity
@Table(name = "tbl_kiubit_curso")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Curso implements Serializable {

    @Id
    private String curso_id;
    private String nombre;
    private String imagen;
    private String descripcion;
    private int duracion_m;
    private int duracion_s;
    private boolean gratuito;
    private String status;

}
