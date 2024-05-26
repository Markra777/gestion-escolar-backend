package org.colegio.web.service;

import org.colegio.web.model.Curso;
import org.colegio.web.model.Docente;
import org.colegio.web.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CursoServiceImpl implements CursoService{

    @Autowired
    private CursoRepository cursoRepository;


    @Override
    public List<Curso> obtenerTodos() {
        return cursoRepository.findAll();
    }

    @Override
    public Curso obtenerPorId(Long id) {
        return cursoRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public void actualizar(Curso curso) {
        cursoRepository.save(curso);
    }

    @Override
    public void eliminar(Long id) {
        cursoRepository.deleteById(id);
    }
}
