package com.universidad.service;

import com.universidad.model.Estudiante;
import com.universidad.model.Materia;
import com.universidad.model.Inscripcion;
import com.universidad.repository.EstudianteRepository;
import com.universidad.repository.MateriaRepository;
import com.universidad.repository.InscripcionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository repo;

    @Autowired
    private EstudianteRepository estudianteRepo;

    @Autowired
    private MateriaRepository materiaRepo;

    public Inscripcion crear(Inscripcion i) {
        // Asegurarse de que los objetos tengan datos válidos desde los IDs
        Estudiante estudiante = estudianteRepo.findById(i.getEstudiante().getId())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        Materia materia = materiaRepo.findById(i.getMateria().getId())
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        i.setEstudiante(estudiante);
        i.setMateria(materia);

        return repo.save(i);
    }

    public Inscripcion obtener(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("No se encontró inscripción"));
    }

    @Cacheable("inscripciones")
    public List<Inscripcion> listar() {
        return repo.findAll();
    }

    public Inscripcion actualizar(Long id, Inscripcion i) {
        Inscripcion actual = obtener(id);

        Estudiante estudiante = estudianteRepo.findById(i.getEstudiante().getId())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        Materia materia = materiaRepo.findById(i.getMateria().getId())
                .orElseThrow(() -> new RuntimeException("Materia no encontrada"));

        actual.setEstudiante(estudiante);
        actual.setMateria(materia);
        actual.setFecha(i.getFecha());

        return repo.save(actual);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
