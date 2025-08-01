package com.example.ExamenT1_DAW.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name="fechaInscripcion", nullable = false)
    private LocalDate fechaInscripcion;

    @ManyToOne()
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne()
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    private EstadoInscripcion estado;

    public enum EstadoInscripcion {
            PENDIENTE, CONFIRMADA, CANCELADA
    }

    public Inscripcion(EstadoInscripcion estado, Estudiante estudiante, LocalDate fechaInscripcion, Curso curso) {
        this.estado = estado;
        this.estudiante = estudiante;
        this.fechaInscripcion = fechaInscripcion;
        this.curso = curso;
    }

    public Inscripcion() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public EstadoInscripcion getEstado() {
        return estado;
    }

    public void setEstado(EstadoInscripcion estado) {
        this.estado = estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFechaIncripcion() {
        return fechaInscripcion;
    }

    public void setFechaIncripcion(LocalDate fechaIncripcion) {
        this.fechaInscripcion = fechaIncripcion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
