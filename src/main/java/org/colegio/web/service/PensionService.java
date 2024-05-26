package org.colegio.web.service;

import org.colegio.web.model.Pension;

import java.util.List;

public interface PensionService {
    List<Pension> obtenerTodos();
    Pension obtenerPorId(Long id);
    void guardar(Pension pension);
    void actualizar(Pension pension);
    void eliminar(Long id);
}
