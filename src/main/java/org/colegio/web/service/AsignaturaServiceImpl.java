package org.colegio.web.service;

import org.colegio.web.model.Asignatura;
import org.colegio.web.repository.AsignaturaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AsignaturaServiceImpl implements AsignaturaService{

    @Autowired
    private AsignaturaRepository asignaturaRepository;


    @Override
    public List<Asignatura> obtenerTodos() {
        return asignaturaRepository.findAll();
    }

    @Override
    public Asignatura obtenerPorId(Long id) {
        return asignaturaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Asignatura asignatura) {
        asignaturaRepository.save(asignatura);
    }

    @Override
    public void actualizar(Asignatura asignatura) {
        asignaturaRepository.save(asignatura);
    }

    @Override
    public void eliminar(Long id) {
        asignaturaRepository.deleteById(id);
    }
}
