package org.colegio.web.controller;


import org.colegio.web.model.NotasBimestrales;
import org.colegio.web.service.NotasBimestralesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/calificaciones")
public class NotasBimestralesController {

    @Autowired
    private NotasBimestralesService notasBimestralesService;

    // Endpoint para obtener todas las notas bimestrales
    @GetMapping
    public ResponseEntity<List<NotasBimestrales>> obtenerTodosLasCalificaciones() {
        List<NotasBimestrales> notasBimestrales = notasBimestralesService.obtenerTodos();
        return new ResponseEntity<>(notasBimestrales, HttpStatus.OK);
    }

    // Endpoint para obtener una calificacion por su ID
    @GetMapping("/{id}")
    public ResponseEntity<NotasBimestrales> obtenerCalificacionesPorId(@PathVariable Long id) {
        NotasBimestrales notaBimestral = notasBimestralesService.obtenerPorId(id);
        if (notaBimestral != null) {
            return new ResponseEntity<>(notaBimestral, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para crear un nueva calificacion
    @PostMapping
    public ResponseEntity<Void> crearCalificacion(@RequestBody NotasBimestrales nuevaCalificacion) {
        notasBimestralesService.guardar(nuevaCalificacion);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint para actualizar una calificacion existente
    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarCalificacion(@PathVariable Long id, @RequestBody NotasBimestrales calificacionActualizada) {
        NotasBimestrales calificacionExistente = notasBimestralesService.obtenerPorId(id);
        if (calificacionExistente != null) {
            calificacionActualizada.setId(id);
            notasBimestralesService.actualizar(calificacionActualizada);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar una calificacion por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCalificacion(@PathVariable Long id) {
        NotasBimestrales calificacionExistente = notasBimestralesService.obtenerPorId(id);
        if (calificacionExistente != null) {
            notasBimestralesService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
