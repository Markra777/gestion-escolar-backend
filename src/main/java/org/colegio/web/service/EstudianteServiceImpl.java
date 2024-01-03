package org.colegio.web.service;

import java.util.List;

import org.colegio.web.model.Estudiante;
import org.colegio.web.repository.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	private EstudianteRepository estudianteRepository;
	
	@Override
	public List<Estudiante> obtenerTodos() {
		
		return estudianteRepository.findAll();
	}

	@Override
	public Estudiante obtenerPorId(Long id) {
		
		return estudianteRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Estudiante estudiante) {
		
		estudianteRepository.save(estudiante);
	}

	@Override
	public void actualizar(Estudiante estudiante) {
		
		estudianteRepository.save(estudiante);
	}

	@Override
	public void eliminar(Long id) {
		
		estudianteRepository.deleteById(id);
	}

}
