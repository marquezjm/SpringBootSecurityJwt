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

/**
 *
 * @author DesarrolloDB
 */
@Entity
@Table(name = "tbl_kiubit_tipo_multimedia")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TipoMultimedia {
    
    @Id
    private String id;
    private String nombre;

    
    
}
