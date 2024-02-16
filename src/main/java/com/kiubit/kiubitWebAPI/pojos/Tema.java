/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kiubit.kiubitWebAPI.pojos;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table(name = "tbl_kiubit_temas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Tema implements Serializable {

    @Id
    private String tema_id;
    private String nombre;
    private String descripcion;
    private int duracion_m;
    private int duracion_s;
    @ManyToOne
    @JoinColumn(name="tipo_multimedia")
    private TipoMultimedia tipo_multimedia;
    private String status;
    
    @ManyToMany
    @JoinTable(name = "tbl_kiubit_tema_actividad",
            joinColumns = @JoinColumn(name = "tema_id"),
            inverseJoinColumns = @JoinColumn(name = "actividad_id"))
    private List<Actividad> actividades = new ArrayList<>();

}
