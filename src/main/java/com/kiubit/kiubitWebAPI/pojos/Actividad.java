/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kiubit.kiubitWebAPI.pojos;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

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
    @ManyToOne
    @JoinColumn(name="creado_por")
    @JsonIgnoreProperties(value = {"role","password","correo","status","enabled","accountNonExpired","credentialsNonExpired","username","authorities","accountNonLocked"},ignoreUnknown = true)
    private Usuario creado_por;
    private Date fecha_creacion;
    private String modificado_por;
    private Date fecha_modificacion;
    @ManyToOne
    @JoinColumn(name="tipo_multimedia")
    private TipoMultimedia tipo_multimedia;
    private String status;

}
