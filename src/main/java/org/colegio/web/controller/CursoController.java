package org.colegio.web.controller;

import org.colegio.web.model.Curso;
import org.colegio.web.model.Docente;
import org.colegio.web.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    // Endpoint para obtener todos los cursos
    @GetMapping
    public ResponseEntity<List<Curso>> obtenerTodosLosCursos() {
        List<Curso> cursos = cursoService.obtenerTodos();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    // Endpoint para obtener un curso por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerCursoPorId(@PathVariable Long id) {
        Curso curso = cursoService.obtenerPorId(id);
        if (curso != null) {
            return new ResponseEntity<>(curso, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para crear un nuevo curso
    @PostMapping
    public ResponseEntity<Void> crearCurso(@RequestBody Curso nuevoCurso) {
        cursoService.guardar(nuevoCurso);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    // Endpoint para actualizar un curso existente
    @PutMapping("/{id}")
    public ResponseEntity<Void> actualizarCurso(@PathVariable Long id, @RequestBody Curso cursoActualizado) {
        Curso cursoExistente = cursoService.obtenerPorId(id);
        if (cursoExistente != null) {
            cursoActualizado.setId(id);
            cursoService.actualizar(cursoActualizado);
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint para eliminar un curso por su ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        Curso cursoExistente = cursoService.obtenerPorId(id);
        if (cursoExistente != null) {
            cursoService.eliminar(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
