package org.colegio.web.service;

import org.colegio.web.model.Curso;

import java.util.List;

public interface CursoService {

    List<Curso> obtenerTodos();
    Curso obtenerPorId(Long id);
    void guardar(Curso curso);
    void actualizar(Curso curso);
    void eliminar(Long id);
}
