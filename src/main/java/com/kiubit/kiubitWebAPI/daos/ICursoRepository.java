package com.kiubit.kiubitWebAPI.daos;

import com.kiubit.kiubitWebAPI.pojos.Curso;
import com.kiubit.kiubitWebAPI.pojos.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICursoRepository extends JpaRepository<Curso,String> {

}
