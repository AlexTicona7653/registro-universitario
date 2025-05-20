package com.universidad.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "ID del estudiante es obligatorio")
    @ManyToOne
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    @NotNull(message = "ID de la materia es obligatorio")
    @ManyToOne
    @JoinColumn(name = "materia_id")
    private Materia materia;

    @NotNull(message = "La fecha es obligatoria")
    private LocalDate fecha;

    // ==== GETTERS ====
    public Long getId() {
        return id;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Materia getMateria() {
        return materia;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    // Accesos rápidos a los IDs si los necesitas
    public Long getEstudianteId() {
        return estudiante != null ? estudiante.getId() : null;
    }

    public Long getMateriaId() {
        return materia != null ? materia.getId() : null;
    }

    // ==== SETTERS ====
    public void setId(Long id) {
        this.id = id;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
