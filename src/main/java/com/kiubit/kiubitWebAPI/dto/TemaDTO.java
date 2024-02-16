package com.kiubit.kiubitWebAPI.dto;

import com.kiubit.kiubitWebAPI.pojos.Actividad;
import com.kiubit.kiubitWebAPI.pojos.TipoMultimedia;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TemaDTO {
    private String tema_id;
    private String nombre;
    private String descripcion;
    private int duracion_m;
    private int duracion_s;
    private TipoMultimedia tipo_multimedia;
    private String status;
    private List<ActividadDTO> actividades = new ArrayList<>();
}
