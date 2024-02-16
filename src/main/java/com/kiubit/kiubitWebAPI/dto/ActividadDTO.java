package com.kiubit.kiubitWebAPI.dto;

import com.kiubit.kiubitWebAPI.pojos.TipoMultimedia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ActividadDTO {
    private String actividad_id;
    private String nombre;
    private String descripcion;
    private int duracion_m;
    private int duracion_s;
    private TipoMultimedia tipo_multimedia;
    private String status;
}
