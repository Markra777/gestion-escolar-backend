package org.colegio.web.service;

import java.util.List;


import org.colegio.web.model.Rol;

public interface RolService {
	
	List<Rol> obtenerTodos();
    Rol obtenerPorId(Long id);
    void guardar(Rol rol);
    void actualizar(Rol rol);
    void eliminar(Long id);

}
