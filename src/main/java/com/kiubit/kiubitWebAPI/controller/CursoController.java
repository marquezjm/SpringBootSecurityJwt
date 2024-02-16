package com.kiubit.kiubitWebAPI.controller;

import com.kiubit.kiubitWebAPI.dto.CursoDTO;
import com.kiubit.kiubitWebAPI.dto.UsuarioDTO;
import com.kiubit.kiubitWebAPI.pojos.Curso;
import com.kiubit.kiubitWebAPI.pojos.EntityResponse;
import com.kiubit.kiubitWebAPI.pojos.Usuario;
import com.kiubit.kiubitWebAPI.service.CursoService;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/curso")
@SecurityRequirement(name = "Bearer Authentication")
public class CursoController {

    @Autowired
    CursoService cursoService;

    @Autowired
    ModelMapper modelMapper;

    @PostMapping("/get-curso/{curso_id}")
    @ResponseBody
    public ResponseEntity<Object> getCurso(@RequestParam String curso_id) {
        Curso curso = cursoService.getCursoById(curso_id).orElse(null);
        CursoDTO respuesta = modelMapper.map(curso,CursoDTO.class);
        return EntityResponse.generateResponse("Retrieve Curso Success", HttpStatus.OK, respuesta);
    }
}
