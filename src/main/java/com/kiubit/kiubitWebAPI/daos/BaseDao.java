/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.kiubit.kiubitWebAPI.daos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author DesarrolloDB
 */
public interface BaseDao {
    <T> T findById(Class<T> type, Serializable id);

    <T> List<T> findAll(Class<T> type);
}
