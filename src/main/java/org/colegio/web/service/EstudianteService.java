package org.colegio.web.service;

import java.util.List;

import org.colegio.web.model.Estudiante;

public interface EstudianteService {
	
	List<Estudiante> obtenerTodos();
    Estudiante obtenerPorId(Long id);
    void guardar(Estudiante estudiante);
    void actualizar(Estudiante estudiante);
    void eliminar(Long id);

}
