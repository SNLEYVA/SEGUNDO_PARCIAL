/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.emergentes.DAO;

import com.emergentes.BD.ConexionDB;
import com.emergentes.MODELO.Rol;
import com.emergentes.MODELO.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Intel i5
 */
public class RolDAOimpl extends ConexionDB implements RolDAO {

    @Override
    public void insert(Rol rol) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("INSERT INTO roles (descripcion) values (?)");
            ps.setString(1, rol.getDescripcion());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Rol rol) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("UPDATE roles SET descripcion = ? where id = ?");
            ps.setString(1, rol.getDescripcion());
            ps.setInt(2, rol.getId());
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try {
            this.conectar();
            PreparedStatement ps = this.conn.prepareStatement("DELETE FROM roles WHERE id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Rol getById(int id) throws Exception {
        Rol cli = new Rol();
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM roles WHERE id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                cli.setId(rs.getInt("id"));
                cli.setDescripcion(rs.getString("descripcion"));
            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return cli;
    }

    @Override
    public List<Rol> getAll() throws Exception {
        
        List<Rol> lista = null;
        try {
            this.conectar();

            PreparedStatement ps = this.conn.prepareStatement("SELECT * FROM roles");
            ResultSet rs = ps.executeQuery();

            lista = new ArrayList<Rol>();
            while (rs.next()) {
                Rol cli = new Rol();

                cli.setId(rs.getInt("id"));
                cli.setDescripcion(rs.getString("descripcion"));
                lista.add(cli);
            }
            rs.close();
            ps.close();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return lista;
    }

}
