/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.DAO;

import com.emergentes.MODELO.Rol;
import com.emergentes.MODELO.Usuario;
import java.util.List;

/**
 *
 * @author Intel i5
 */
public interface RolDAO {
    public void insert(Rol rol) throws Exception;
    public void update(Rol rol) throws Exception;
    public void delete(int id) throws Exception;
    public Rol getById(int id) throws Exception;
    public List<Rol> getAll() throws Exception;     
}
