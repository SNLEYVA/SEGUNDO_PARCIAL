package com.emergentes.DAO;

import com.emergentes.BD.ConexionDB;
import com.emergentes.MODELO.Permiso;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Intel i5
 */
public class PermisoDAOimpl extends ConexionDB implements PermisoDAO {

    @Override
    public void insert(Permiso permiso) throws Exception {
        try {
            this.conectar();
            String sql = "INSERT INTO permisos (id_usuario, id_rol) values (?,?)";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ps.setInt(1, permiso.getId_usuario());
            ps.setInt(2, permiso.getId_rol());

            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public void update(Permiso permiso) throws Exception {
        try {
            this.conectar();
            String sql = "UPDATE permisos SET id_usuario = ?, id_rol = ? WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);

            ps.setInt(1, permiso.getId_usuario());
            ps.setInt(2, permiso.getId_rol());
            ps.setInt(3, permiso.getId());
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
            String sql = "DELETE FROM permisos WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
    }

    @Override
    public Permiso getById(int id) throws Exception {
        Permiso v = new Permiso();
        try {
            this.conectar();
            String sql = "SELECT * FROM permisos WHERE id = ?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                v.setId(rs.getInt("id"));
                v.setId(rs.getInt("id_usuario"));
                v.setId(rs.getInt("id_rol"));

            }

        } catch (Exception e) {
            throw e;
        } finally {
            this.desconectar();
        }
        return v;
    }

    @Override
    public List<Permiso> getAll() throws Exception {
        List<Permiso> lista = null;
        try {
            this.conectar();
            String sql = "SELECT v.*,p.usuario as usuarios, c.descripcion as roles FROM permisos v ";
            sql += "LEFT JOIN usuarios p ON v.id_usuario = p.id ";
            sql += "LEFT JOIN roles c ON v.id_rol = c.id";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            lista = new ArrayList<Permiso>();
            while (rs.next()) {
                Permiso v = new Permiso();
                v.setId(rs.getInt("id"));
                v.setId_usuario(rs.getInt("id_usuario"));
                v.setId_rol(rs.getInt("id_rol"));
                v.setUsuario(rs.getString("usuarios"));
                v.setDescripcion(rs.getString("roles"));
                lista.add(v);
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
