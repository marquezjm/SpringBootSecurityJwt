package com.kiubit.kiubitWebAPI.dto;

import com.kiubit.kiubitWebAPI.pojos.Tema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ModuloDTO {
    private String modulo_id;
    private String nombre;
    private String descripcion;
    private int duracion_m;
    private int duracion_s;
    private String status;
    private List<TemaDTO> temas= new ArrayList<>();
}
