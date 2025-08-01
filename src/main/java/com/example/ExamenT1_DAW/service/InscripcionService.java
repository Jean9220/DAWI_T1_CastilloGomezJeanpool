package com.example.ExamenT1_DAW.service;

import com.example.ExamenT1_DAW.entity.Curso;
import com.example.ExamenT1_DAW.entity.Estudiante;
import com.example.ExamenT1_DAW.entity.Inscripcion;
import com.example.ExamenT1_DAW.entity.Inscripcion.EstadoInscripcion;

import jakarta.persistence.EntityManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class InscripcionService {

    public List<Inscripcion> crearInscripciones(List<Estudiante> estudiantes, List<Curso> cursos) {
        List<Inscripcion> lista = new ArrayList<>();

        lista.add(new Inscripcion(EstadoInscripcion.CONFIRMADA, estudiantes.get(11), LocalDate.of(2025, 7, 1), cursos.get(6)));
        lista.add(new Inscripcion(EstadoInscripcion.CONFIRMADA, estudiantes.get(11), LocalDate.of(2025, 7, 2), cursos.get(1)));
        lista.add(new Inscripcion(EstadoInscripcion.CONFIRMADA, estudiantes.get(11), LocalDate.of(2025, 7, 3), cursos.get(2)));

        lista.add(new Inscripcion(EstadoInscripcion.PENDIENTE, estudiantes.get(1), LocalDate.of(2025, 7, 1), cursos.get(9)));
        lista.add(new Inscripcion(EstadoInscripcion.CONFIRMADA, estudiantes.get(1), LocalDate.of(2025, 7, 2), cursos.get(3)));
        lista.add(new Inscripcion(EstadoInscripcion.CONFIRMADA, estudiantes.get(1), LocalDate.of(2025, 7, 3), cursos.get(4)));

        lista.add(new Inscripcion(EstadoInscripcion.CONFIRMADA, estudiantes.get(2), LocalDate.of(2025, 7, 4), cursos.get(7)));
        lista.add(new Inscripcion(EstadoInscripcion.CONFIRMADA, estudiantes.get(2), LocalDate.of(2025, 7, 5), cursos.get(1)));

        lista.add(new Inscripcion(EstadoInscripcion.CANCELADA, estudiantes.get(3), LocalDate.of(2025, 7, 6), cursos.get(1)));
        lista.add(new Inscripcion(EstadoInscripcion.CONFIRMADA, estudiantes.get(4), LocalDate.of(2025, 7, 7), cursos.get(2)));

        lista.add(new Inscripcion(EstadoInscripcion.PENDIENTE, estudiantes.get(5), LocalDate.of(2025, 7, 8), cursos.get(2)));
        lista.add(new Inscripcion(EstadoInscripcion.CONFIRMADA, estudiantes.get(5), LocalDate.of(2025, 7, 9), cursos.get(3)));

        lista.add(new Inscripcion(EstadoInscripcion.CONFIRMADA, estudiantes.get(6), LocalDate.of(2025, 7, 10), cursos.get(4)));
        lista.add(new Inscripcion(EstadoInscripcion.CONFIRMADA, estudiantes.get(7), LocalDate.of(2025, 7, 11), cursos.get(12)));

        return lista;
    }
}
