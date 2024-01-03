package org.colegio.web.controller;


import java.util.List;

import org.colegio.web.model.Estudiante;
import org.colegio.web.service.EstudianteService;
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
@RequestMapping("api/v1/estudiantes")
public class EstudianteController {
	
	@Autowired
    private EstudianteService estudianteService;
	
	// Endpoint para obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Estudiante>> obtenerTodosLosUsuarios() {
        List<Estudiante> estudiantes = estudianteService.obtenerTodos();
        return new ResponseEntity<>(estudiantes, HttpStatus.OK);
    }
    
 // Endpoint para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Estudiante> obtenerUsuarioPorId(@PathVariable Long id) {
        Estudiante estudiante = estudianteService.obtenerPorId(id);
        if (estudiante != null) {
            return new ResponseEntity<>(estudiante, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
 // Endpoint para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Void> crearEstudiante(@RequestBody Estudiante nuevoEstudiante) {
        estudianteService.guardar(nuevoEstudiante);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
 // Endpoint para actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarEstudiante(@PathVariable Long id, @RequestBody Estudiante estudianteActualizado) {
        Estudiante estudianteExistente = estudianteService.obtenerPorId(id);
        if (estudianteExistente != null) {
            estudianteActualizado.setId(id);
            estudianteService.actualizar(estudianteActualizado);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
 // Endpoint para eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarEstudiante(@PathVariable Long id) {
        Estudiante estudianteExistente = estudianteService.obtenerPorId(id);
        if (estudianteExistente != null) {
            estudianteService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
