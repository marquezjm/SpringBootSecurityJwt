/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kiubit.kiubitWebAPI.pojos;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

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
    @ManyToMany
    @JoinTable(name = "tbl_kiubit_curso_modulo",
                joinColumns = @JoinColumn(name = "curso_id"),
                inverseJoinColumns = @JoinColumn(name = "modulo_id"))
    private List<Modulo> modulos=new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "tbl_kiubit_curso_actividad",
            joinColumns = @JoinColumn(name = "curso_id"),
            inverseJoinColumns = @JoinColumn(name = "actividad_id"))
    private List<Actividad> actividades = new ArrayList<>();

}
