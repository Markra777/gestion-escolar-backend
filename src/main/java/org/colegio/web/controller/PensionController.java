package org.colegio.web.controller;

import org.colegio.web.model.Docente;
import org.colegio.web.model.Pension;
import org.colegio.web.service.PensionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/pensiones")
public class PensionController {

    @Autowired
    private PensionService pensionService;

    // Endpoint para obtener todas las pensiones
    @GetMapping
    public ResponseEntity<List<Pension>> obtenerTodasLasPensiones() {
        List<Pension> pensiones = pensionService.obtenerTodos();
        return new ResponseEntity<>(pensiones, HttpStatus.OK);
    }

    // Endpoint para obtener una pension por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Pension> obtenerPensionPorId(@PathVariable Long id) {
        Pension pension = pensionService.obtenerPorId(id);
        if (pension != null) {
            return new ResponseEntity<>(pension, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para crear una nueva pension
    @PostMapping
    public ResponseEntity<Void> crearPension(@RequestBody Pension nuevaPension) {
        pensionService.guardar(nuevaPension);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint para actualizar una pension existente
    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarPension(@PathVariable Long id, @RequestBody Pension pensionActualizada) {
        Pension pensionExistente = pensionService.obtenerPorId(id);
        if (pensionExistente != null) {
            pensionActualizada.setId(id);
            pensionService.actualizar(pensionActualizada);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar una pension por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarPension(@PathVariable Long id) {
        Pension pensionExistente = pensionService.obtenerPorId(id);
        if (pensionExistente != null) {
            pensionService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
