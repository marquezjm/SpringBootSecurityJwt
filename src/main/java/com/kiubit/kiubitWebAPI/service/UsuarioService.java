/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.kiubit.kiubitWebAPI.service;

import com.kiubit.kiubitWebAPI.daos.IUserRepository;
import com.kiubit.kiubitWebAPI.pojos.Role;
import com.kiubit.kiubitWebAPI.pojos.Usuario;
import com.kiubit.kiubitWebAPI.security.SecurityPrincipal;
import jakarta.transaction.Transactional;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP
 */
@Service
@Transactional
public class UsuarioService implements UserDetailsService {

    @Autowired
    private IUserRepository userRepository;

    //@Autowired
    //private IRoleRepository userRoleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = userRepository.findByCorreo(username);
        return usuario;
    }

    public Usuario findByUsername(String username) {
        return userRepository.findByCorreo(username);
    }

    public String createUser(Usuario userRequestDTO) {

        try {
            validateRegistrationDetails(userRequestDTO);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return e.getMessage();
        }
        try {
            userRequestDTO.getRole().setRol_id("U");

            Usuario user = userRepository.save(userRequestDTO);

            return "User successfully created.";
        } catch (Exception e) {
            e.printStackTrace();
            return e.getCause().getMessage();
        }

    }

    private void validateRegistrationDetails(Usuario userRequestDTO) throws Exception {
        if (findByUsername(userRequestDTO.getCorreo()) != null) {
            throw new Exception("Username already exists.");
        }

        /*if (entityService.findByEmail(userRequestDTO.getEmail()) != null) {
            throw new Exception("Email already exists.");
        }*/
 /*if (entityService.findByEntityNo(userRequestDTO.getEntityNo()) != null) {
            throw new Exception("Entity Number already exists.");
        }*/
 /*if (entityService.findByMobile(userRequestDTO.getMobile()) != null) {
            throw new Exception("Mobile already exists.");
        }*/
    }

    public Usuario updateUser(Usuario userRequestDTO) {

        //Usuario user = (Usuario) dtoMapperRequestDtoToUser(userRequestDTO);
        userRequestDTO.getRole().setRol_id("U");
        Usuario usuario = userRepository.save(userRequestDTO);
        //addUserRole(user, null);

        return usuario;
    }

    public Role findAllCurrentUserRole() {
        return userRepository.findByCorreo(SecurityPrincipal.getInstance().getLoggedInPrincipal().getCorreo()).getRole();
    }

    public Optional<Usuario> findUserById(String id) {
        return userRepository.findById(id);
    }

}
