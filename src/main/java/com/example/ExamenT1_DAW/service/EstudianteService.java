package com.example.ExamenT1_DAW.service;

import com.example.ExamenT1_DAW.entity.Estudiante;

import java.util.ArrayList;
import java.util.List;

public class EstudianteService {

    public List<Estudiante> crearEstudiantesPrueba() {
        List<Estudiante> lista = new ArrayList<>();

        lista.add(new Estudiante("Juan Pérez", "juan@example.com", "MAT001"));
        lista.add(new Estudiante("Lucía Díaz", "lucia@example.com", "MAT002"));
        lista.add(new Estudiante("Carlos Gómez", "carlos@example.com", "MAT003"));
        lista.add(new Estudiante("Ana Torres", "ana@example.com", "MAT004"));
        lista.add(new Estudiante("Luis Vega", "luis@example.com", "MAT005"));
        lista.add(new Estudiante("Sofía Ríos", "sofia@example.com", "MAT006"));
        lista.add(new Estudiante("Pedro Luna", "pedro@example.com", "MAT007"));
        lista.add(new Estudiante("María Silva", "maria@example.com", "MAT008"));
        lista.add(new Estudiante("José Fernández", "jose@example.com", "MAT009"));
        lista.add(new Estudiante("Elena Vargas", "elena@example.com", "MAT010"));
        lista.add(new Estudiante("Raúl Cabrera", "raul@example.com", "MAT011"));
        lista.add(new Estudiante("Carmen Paredes", "carmen@example.com", "MAT012"));
        lista.add(new Estudiante("Daniel Ortega", "daniel@example.com", "MAT013"));
        lista.add(new Estudiante("Andrea Muñoz", "andrea@example.com", "MAT014"));
        lista.add(new Estudiante("Felipe Ramos", "felipe@example.com", "MAT015"));

        return lista;
    }
}
