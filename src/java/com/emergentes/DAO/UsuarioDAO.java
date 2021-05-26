
package com.emergentes.DAO;

import com.emergentes.MODELO.Usuario;
import java.util.List;

public interface UsuarioDAO {
    public void insert(Usuario usuario) throws Exception;
    public void update(Usuario usuario) throws Exception;
    public void delete(int id) throws Exception;
    public Usuario getById(int id) throws Exception;
    public List<Usuario> getAll() throws Exception;    
}
