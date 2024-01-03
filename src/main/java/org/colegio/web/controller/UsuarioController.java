package org.colegio.web.controller;

import java.util.List;

import org.colegio.web.model.Usuario;
import org.colegio.web.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {
	
	@Autowired
    private UsuarioService usuarioService;
	
	// Endpoint para obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = usuarioService.obtenerTodos();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }
    
 // Endpoint para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> obtenerUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.obtenerPorId(id);
        if (usuario != null) {
            return new ResponseEntity<>(usuario, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
 // Endpoint para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Void> crearUsuario(@RequestBody Usuario nuevoUsuario) {
        usuarioService.guardar(nuevoUsuario);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
 // Endpoint para actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuarioActualizado) {
        Usuario usuarioExistente = usuarioService.obtenerPorId(id);
        if (usuarioExistente != null) {
            usuarioActualizado.setId(id);
            usuarioService.actualizar(usuarioActualizado);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
 // Endpoint para eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarUsuario(@PathVariable Long id) {
        Usuario usuarioExistente = usuarioService.obtenerPorId(id);
        if (usuarioExistente != null) {
            usuarioService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
