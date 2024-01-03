package org.colegio.web.controller;


import java.util.List;

import org.colegio.web.model.Docente;
import org.colegio.web.service.DocenteService;
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
@RequestMapping("api/v1/docentes")
public class DocenteController {
	
	@Autowired
    private DocenteService docenteService;
	
	// Endpoint para obtener todos los usuarios
    @GetMapping
    public ResponseEntity<List<Docente>> obtenerTodosLosDocentes() {
        List<Docente> docentes = docenteService.obtenerTodos();
        return new ResponseEntity<>(docentes, HttpStatus.OK);
    }
    
 // Endpoint para obtener un usuario por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Docente> obtenerDocentePorId(@PathVariable Long id) {
        Docente docente = docenteService.obtenerPorId(id);
        if (docente != null) {
            return new ResponseEntity<>(docente, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
 // Endpoint para crear un nuevo usuario
    @PostMapping
    public ResponseEntity<Void> crearDocente(@RequestBody Docente nuevoDocente) {
        docenteService.guardar(nuevoDocente);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    
 // Endpoint para actualizar un usuario existente
    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarDocente(@PathVariable Long id, @RequestBody Docente docenteActualizado) {
        Docente docenteExistente = docenteService.obtenerPorId(id);
        if (docenteExistente != null) {
            docenteActualizado.setId(id);
            docenteService.actualizar(docenteActualizado);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    
 // Endpoint para eliminar un usuario por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarDocente(@PathVariable Long id) {
        Docente docenteExistente = docenteService.obtenerPorId(id);
        if (docenteExistente != null) {
            docenteService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
