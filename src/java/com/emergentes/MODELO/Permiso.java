package com.emergentes.MODELO;

/**
 *
 * @author Intel i5
 */
public class Permiso {

    private int id;
    private int id_usuario;
    private int id_rol;
    private String usuario;
    private String descripcion;

    public Permiso() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public int getId_rol() {
        return id_rol;
    }

    public void setId_rol(int id_rol) {
        this.id_rol = id_rol;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Permiso{" + "id=" + id + ", id_usuario=" + id_usuario + ", id_rol=" + id_rol + ", usuario=" + usuario + ", descripcion=" + descripcion +'}';
    }
}
