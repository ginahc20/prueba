/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package service;

import java.util.List;

/**
 *
 * @author GINA HUERTAS
 */
public interface ICrudDao<T> {
    //definir las firmas

    int create(T t) throws Exception;

    int update(T t) throws Exception;

    int delete(T t) throws Exception;

    T findById(String t) throws Exception;

    List<T> readAll() throws Exception;
}
