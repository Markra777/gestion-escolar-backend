package org.colegio.web.service;

import java.util.List;

import org.colegio.web.model.Usuario;
import org.colegio.web.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public List<Usuario> obtenerTodos() {		
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario obtenerPorId(Long id) {		
		return usuarioRepository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Usuario usuario) {
		usuarioRepository.save(usuario);	
	}

	@Override
	public void actualizar(Usuario usuario) {
		usuarioRepository.save(usuario);
		
	}

	@Override
	public void eliminar(Long id) {
		usuarioRepository.deleteById(id);	
	}

}
