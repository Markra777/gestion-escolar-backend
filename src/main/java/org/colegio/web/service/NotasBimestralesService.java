package org.colegio.web.service;

import org.colegio.web.model.NotasBimestrales;

import java.util.List;

public interface NotasBimestralesService {
    List<NotasBimestrales> obtenerTodos();
    NotasBimestrales obtenerPorId(Long id);
    void guardar(NotasBimestrales notasBimestrales);
    void actualizar(NotasBimestrales notasBimestrales);
    void eliminar(Long id);
}
