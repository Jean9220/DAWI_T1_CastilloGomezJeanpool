package com.example.ExamenT1_DAW.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "inscripcion")
public class Inscripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;
    @Column(name="fechaIncripcion", nullable = false)
    private LocalDate fechaIncripcion;

    @ManyToOne()
    @JoinColumn(name = "curso_id")
    private Curso curso;

    @ManyToOne()
    @JoinColumn(name = "estudiante_id")
    private Estudiante estudiante;

    private Estado estado;

    public enum Estado {
            PENDIENTE, CONFIRMADA, CANCELADA
    }

    public Inscripcion(Estado estado, Estudiante estudiante, LocalDate fechaIncripcion, Curso curso, long id) {
        this.estado = estado;
        this.estudiante = estudiante;
        this.fechaIncripcion = fechaIncripcion;
        this.curso = curso;
        Id = id;
    }

    public Inscripcion() {
    }

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiante estudiante) {
        this.estudiante = estudiante;
    }

    public LocalDate getFechaIncripcion() {
        return fechaIncripcion;
    }

    public void setFechaIncripcion(LocalDate fechaIncripcion) {
        this.fechaIncripcion = fechaIncripcion;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
