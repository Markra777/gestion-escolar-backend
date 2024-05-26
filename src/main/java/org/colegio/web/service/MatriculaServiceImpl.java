package org.colegio.web.service;

import org.colegio.web.model.Matricula;
import org.colegio.web.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MatriculaServiceImpl implements MatriculaService{

    @Autowired
    private MatriculaRepository matriculaRepository;


    @Override
    public List<Matricula> obtenerTodos() {
        return matriculaRepository.findAll();
    }

    @Override
    public Matricula obtenerPorId(Long id) {
        return matriculaRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Matricula matricula) {
        matriculaRepository.save(matricula);
    }

    @Override
    public void actualizar(Matricula matricula) {
        matriculaRepository.save(matricula);
    }

    @Override
    public void eliminar(Long id) {
        matriculaRepository.deleteById(id);
    }
}
