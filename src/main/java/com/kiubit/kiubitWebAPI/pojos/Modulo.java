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
@Table(name = "tbl_kiubit_modulos")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Modulo implements Serializable {

    @Id
    private String modulo_id;
    private String nombre;
    private String descripcion;
    private int duracion_m;
    private int duracion_s;
    private String status;
    
    @ManyToMany
    @JoinTable(name = "tbl_kiubit_modulo_tema",
            joinColumns = @JoinColumn(name = "modulo_id"),
            inverseJoinColumns = @JoinColumn(name = "tema_id"))
    private List<Tema> temas= new ArrayList<>();

}
