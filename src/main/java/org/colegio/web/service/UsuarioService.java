package org.colegio.web.service;

import java.util.List;

import org.colegio.web.model.Usuario;

public interface UsuarioService {

	List<Usuario> obtenerTodos();
    Usuario obtenerPorId(Long id);
    void guardar(Usuario usuario);
    void actualizar(Usuario usuario);
    void eliminar(Long id);
}
