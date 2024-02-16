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
@Table(name = "tbl_kiubit_curso_actividad")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CursoActividad implements Serializable {

    @Id
    private String curso_id;
    @Id
    private String actividad_id;

}
