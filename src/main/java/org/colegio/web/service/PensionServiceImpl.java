package org.colegio.web.service;

import org.colegio.web.model.Docente;
import org.colegio.web.model.Pension;
import org.colegio.web.repository.PensionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PensionServiceImpl implements PensionService{

    @Autowired
    private PensionRepository pensionRepository;

    @Override
    public List<Pension> obtenerTodos() {
        return pensionRepository.findAll();
    }

    @Override
    public Pension obtenerPorId(Long id) {
        return pensionRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(Pension pension) {
        pensionRepository.save(pension);
    }

    @Override
    public void actualizar(Pension pension) {
        pensionRepository.save(pension);
    }

    @Override
    public void eliminar(Long id) {
        pensionRepository.deleteById(id);
    }
}
