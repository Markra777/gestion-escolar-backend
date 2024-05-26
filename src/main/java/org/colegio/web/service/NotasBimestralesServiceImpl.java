package org.colegio.web.service;


import org.colegio.web.model.NotasBimestrales;
import org.colegio.web.repository.NotasBimestralesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotasBimestralesServiceImpl implements NotasBimestralesService{


    private NotasBimestralesRepository notasBimestralesRepository;

    @Override
    public List<NotasBimestrales> obtenerTodos() {
        return notasBimestralesRepository.findAll();
    }

    @Override
    public NotasBimestrales obtenerPorId(Long id) {
        return notasBimestralesRepository.findById(id).orElse(null);
    }

    @Override
    public void guardar(NotasBimestrales notasBimestrales) {
        notasBimestralesRepository.save(notasBimestrales);
    }

    @Override
    public void actualizar(NotasBimestrales notasBimestrales) {
        notasBimestralesRepository.save(notasBimestrales);
    }

    @Override
    public void eliminar(Long id) {
        notasBimestralesRepository.deleteById(id);
    }
}
