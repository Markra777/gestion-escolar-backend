package org.colegio.web.service;

import java.util.List;

import org.colegio.web.model.Rol;
import org.colegio.web.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServiceImpl implements RolService{

	@Autowired
	private RolRepository rolRepository;
	
	@Override
	public List<Rol> obtenerTodos() {
		
		return rolRepository.findAll();
	}

	@Override
	public Rol obtenerPorId(Long id) {
		
		return rolRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Rol rol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizar(Rol rol) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminar(Long id) {
		// TODO Auto-generated method stub
		
	}

}
