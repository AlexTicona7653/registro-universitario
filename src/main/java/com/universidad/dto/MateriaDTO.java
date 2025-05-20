package com.universidad.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MateriaDTO implements Serializable {

    private Long id;
    private String nombreMateria;
    private String codigoUnico;
    private Integer creditos;

    /**
     * Lista de IDs de materias que son prerequisitos para esta materia.
     */
    private List<Long> prerequisitos;

    /**
     * Lista de IDs de materias para las que esta materia es prerequisito.
     */
    private List<Long> esPrerequisitoDe;

    @NotNull(message = "El ID del docente no puede ser nulo")
    private Long docenteId;







    @NotNull(message = "El nombre no puede ser nulo")
    private String nombre;

        @NotNull(message = "El código no puede ser nulo")
        private String codigo;



        // Getters y setters

        public String getNombre() {
            return nombre;
        }

        public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public String getCodigo() {
            return codigo;
        }

        public void setCodigo(String codigo) {
            this.codigo = codigo;
        }

        public Long getDocenteId() {
            return docenteId;
        }

        public void setDocenteId(Long docenteId) {
            this.docenteId = docenteId;
        }



}