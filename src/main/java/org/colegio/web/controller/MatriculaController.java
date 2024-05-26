package org.colegio.web.controller;

import org.colegio.web.model.Matricula;
import org.colegio.web.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService matriculaService;

    // Endpoint para obtener todas las matriculas
    @GetMapping
    public ResponseEntity<List<Matricula>> obtenerTodasLasMatriculas() {
        List<Matricula> matriculas = matriculaService.obtenerTodos();
        return new ResponseEntity<>(matriculas, HttpStatus.OK);
    }

    // Endpoint para obtener una matricula por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Matricula> obtenerMatriculaPorId(@PathVariable Long id) {
        Matricula matricula = matriculaService.obtenerPorId(id);
        if (matricula != null) {
            return new ResponseEntity<>(matricula, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para crear una nueva matricula
    @PostMapping
    public ResponseEntity<Void> crearMatricula(@RequestBody Matricula nuevaMatricula) {
        matriculaService.guardar(nuevaMatricula);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint para actualizar una matricula existente
    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarMatricula(@PathVariable Long id, @RequestBody Matricula matriculaActualizada) {
        Matricula matriculaExistente = matriculaService.obtenerPorId(id);
        if (matriculaExistente != null) {
            matriculaActualizada.setId(id);
            matriculaService.actualizar(matriculaActualizada);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar una matricula por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMatricula(@PathVariable Long id) {
        Matricula matriculaExistente = matriculaService.obtenerPorId(id);
        if (matriculaExistente != null) {
            matriculaService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
