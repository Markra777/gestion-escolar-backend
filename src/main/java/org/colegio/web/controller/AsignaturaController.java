package org.colegio.web.controller;

import org.colegio.web.model.Asignatura;
import org.colegio.web.model.Docente;
import org.colegio.web.service.AsignaturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/asignaturas")
public class AsignaturaController {

    @Autowired
    private AsignaturaService asignaturaService;

    // Endpoint para obtener todas las asignaturas
    @GetMapping
    public ResponseEntity<List<Asignatura>> obtenerTodasLasAsignaturas() {
        List<Asignatura> asignaturas = asignaturaService.obtenerTodos();
        return new ResponseEntity<>(asignaturas, HttpStatus.OK);
    }

    // Endpoint para obtener una asignatura por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Asignatura> obtenerAsignaturaPorId(@PathVariable Long id) {
        Asignatura asignatura = asignaturaService.obtenerPorId(id);
        if (asignatura != null) {
            return new ResponseEntity<>(asignatura, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para crear una nueva asignatura
    @PostMapping
    public ResponseEntity<Void> crearAsignatura(@RequestBody Asignatura nuevaAsignatura) {
        asignaturaService.guardar(nuevaAsignatura);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint para actualizar una asignatura existente
    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarAsignatura(@PathVariable Long id, @RequestBody Asignatura asignaturaActualizada) {
        Asignatura asignaturaExistente = asignaturaService.obtenerPorId(id);
        if (asignaturaExistente != null) {
            asignaturaActualizada.setId(id);
            asignaturaService.actualizar(asignaturaActualizada);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar una asignatura por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarAsignatura(@PathVariable Long id) {
        Asignatura asignaturaExistente = asignaturaService.obtenerPorId(id);
        if (asignaturaExistente != null) {
            asignaturaService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
