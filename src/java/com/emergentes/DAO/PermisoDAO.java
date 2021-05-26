/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.DAO;

import com.emergentes.MODELO.Permiso;
import java.util.List;

/**
 *
 * @author Intel i5
 */
public interface PermisoDAO {
    public void insert(Permiso permiso) throws Exception;
    public void update(Permiso permiso) throws Exception;
    public void delete(int id) throws Exception;
    public Permiso getById(int id) throws Exception;
    public List<Permiso> getAll() throws Exception;           
}
