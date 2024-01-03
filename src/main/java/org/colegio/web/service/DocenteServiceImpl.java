package org.colegio.web.service;

import java.util.List;

import org.colegio.web.model.Docente;
import org.colegio.web.repository.DocenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DocenteServiceImpl implements DocenteService{

	@Autowired
	private DocenteRepository docenteRepository;
	
	@Override
	public List<Docente> obtenerTodos() {
		
		return docenteRepository.findAll();
	}

	@Override
	public Docente obtenerPorId(Long id) {
		
		return docenteRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Docente docente) {
		
		docenteRepository.save(docente);
	}

	@Override
	public void actualizar(Docente docente) {
		
		docenteRepository.save(docente);
	}

	@Override
	public void eliminar(Long id) {
		
		
	}

}
