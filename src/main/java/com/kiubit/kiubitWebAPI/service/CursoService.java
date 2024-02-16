package com.kiubit.kiubitWebAPI.service;

import com.kiubit.kiubitWebAPI.daos.ICursoRepository;
import com.kiubit.kiubitWebAPI.pojos.Curso;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class CursoService {
    @Autowired
    private ICursoRepository cursoRepository;

    public Optional<Curso> getCursoById(String curso_id){
        Optional<Curso> curso = cursoRepository.findById(curso_id);
        return curso;
    }
}
