package org.colegio.web.service;

import org.colegio.web.model.Matricula;

import java.util.List;

public interface MatriculaService {

    List<Matricula> obtenerTodos();
    Matricula obtenerPorId(Long id);
    void guardar(Matricula matricula);
    void actualizar(Matricula matricula);
    void eliminar(Long id);
}
