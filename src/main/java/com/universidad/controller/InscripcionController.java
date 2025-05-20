package com.universidad.controller;

import com.universidad.model.Inscripcion;
import com.universidad.service.InscripcionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService servicio;

    @PreAuthorize("hasRole('USER')")
    @PostMapping
    public ResponseEntity<Inscripcion> crear(@Valid @RequestBody Inscripcion i) {
        return ResponseEntity.ok(servicio.crear(i));
    }

    @GetMapping
    public List<Inscripcion> listar() {
        return servicio.listar();
    }

    @GetMapping("/{id}")
    public Inscripcion obtener(@PathVariable Long id) {
        return servicio.obtener(id);
    }

    @PutMapping("/{id}")
    public Inscripcion actualizar(@PathVariable Long id, @Valid @RequestBody Inscripcion i) {
        return servicio.actualizar(id, i);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
    }
}
