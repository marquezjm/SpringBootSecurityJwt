package com.kiubit.kiubitWebAPI.dto;

import com.kiubit.kiubitWebAPI.pojos.Actividad;
import com.kiubit.kiubitWebAPI.pojos.Modulo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CursoDTO {
    private String curso_id;
    private String nombre;
    private String imagen;
    private String descripcion;
    private int duracion_m;
    private int duracion_s;
    private boolean gratuito;
    private String status;
    private List<ModuloDTO> modulos=new ArrayList<>();
    private List<ActividadDTO> actividades = new ArrayList<>();
}
