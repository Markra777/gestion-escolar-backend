package org.colegio.web.service;

import org.colegio.web.model.Asignatura;

import java.util.List;

public interface AsignaturaService {

    List<Asignatura> obtenerTodos();
    Asignatura obtenerPorId(Long id);
    void guardar(Asignatura asignatura);
    void actualizar(Asignatura asignatura);
    void eliminar(Long id);
}
