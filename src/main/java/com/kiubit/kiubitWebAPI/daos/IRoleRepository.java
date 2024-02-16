/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kiubit.kiubitWebAPI.daos;

import com.kiubit.kiubitWebAPI.pojos.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author DesarrolloDB
 */
@Repository
public interface IRoleRepository extends JpaRepository<Role,String> {
    
}
