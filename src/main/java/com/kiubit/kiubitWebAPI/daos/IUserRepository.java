/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kiubit.kiubitWebAPI.daos;

import com.kiubit.kiubitWebAPI.pojos.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DesarrolloDB
 */
@Repository
public interface IUserRepository extends JpaRepository<Usuario,String>{
    Usuario findUserByCorreoAndPassword(String correo, String password);
    
    Usuario findByCorreo(String correo);
}
