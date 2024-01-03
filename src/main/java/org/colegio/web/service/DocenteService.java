package org.colegio.web.service;

import java.util.List;

import org.colegio.web.model.Docente;

public interface DocenteService {
	
	List<Docente> obtenerTodos();
    Docente obtenerPorId(Long id);
    void guardar(Docente docente);
    void actualizar(Docente docente);
    void eliminar(Long id);

}
