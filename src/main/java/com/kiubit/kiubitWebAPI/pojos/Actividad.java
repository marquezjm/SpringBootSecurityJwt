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

/**
 *
 * @author DesarrolloDB
 */

@Entity
@Table(name = "tbl_kiubit_actividades")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Actividad implements Serializable {

    @Id
    private String actividad_id;
    private String nombre;
    private String descripcion;
    private int duracion_m;
    private int duracion_s;
    private String tipo_multimedia;
    private String status;

}
