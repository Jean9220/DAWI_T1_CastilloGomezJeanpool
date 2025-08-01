package com.example.ExamenT1_DAW.service;

import com.example.ExamenT1_DAW.entity.Profesor;

import java.util.ArrayList;
import java.util.List;

public class ProfesorService {

    public List<Profesor> crearProfesoresPrueba() {
        List<Profesor> lista = new ArrayList<>();

        lista.add(new Profesor("Alejandra Ruiz", "Realidad Aumentada"));
        lista.add(new Profesor("Gabriel Montoya", "Computación Cuántica"));
        lista.add(new Profesor("Isabel Valdez", "Análisis de Datos"));
        lista.add(new Profesor("Tomás Espinoza", "Blockchain y Finanzas"));
        lista.add(new Profesor("Daniela Aguirre", "Robótica Industrial"));
        lista.add(new Profesor("Ramiro Quispe", "Automatización de Procesos"));
        lista.add(new Profesor("Claudia Salazar", "Diseño de Interfaces"));
        lista.add(new Profesor("Ernesto Paredes", "Cómputo en la Nube"));
        lista.add(new Profesor("Verónica Chávez", "Innovación Tecnológica"));
        lista.add(new Profesor("Sebastián Linares", "Programación Funcional"));
        lista.add(new Profesor("Julieta Mendoza", "Minería de Datos"));
        lista.add(new Profesor("Álvaro Castañeda", "Testing y Calidad de Software"));
        lista.add(new Profesor("Camila Vega", "Ciberdefensa Estratégica"));
        lista.add(new Profesor("Rodrigo Cárdenas", "Gestión de Servicios TI"));
        lista.add(new Profesor("Andrea Solís", "Ética Profesional en TI"));

        return lista;
    }
}
