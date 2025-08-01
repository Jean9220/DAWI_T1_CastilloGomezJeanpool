package com.example.ExamenT1_DAW.service;

import com.example.ExamenT1_DAW.entity.Curso;

import java.util.ArrayList;
import java.util.List;

public class CursoService {

    public List<Curso> crearCursosPrueba() {
        List<Curso> lista = new ArrayList<>();

        lista.add(new Curso("Matemáticas Básicas", "CUR001", 3));
        lista.add(new Curso("Programación en Java", "CUR002", 4));
        lista.add(new Curso("Base de Datos", "CUR003", 4));
        lista.add(new Curso("Desarrollo Web", "CUR004", 5));
        lista.add(new Curso("Redes de Computadoras", "CUR005", 3));
        lista.add(new Curso("Sistemas Operativos", "CUR006", 3));
        lista.add(new Curso("Algoritmos y Estructuras", "CUR007", 4));
        lista.add(new Curso("Inteligencia Artificial", "CUR008", 5));
        lista.add(new Curso("Gestión de Proyectos", "CUR009", 3));
        lista.add(new Curso("Seguridad Informática", "CUR010", 3));
        lista.add(new Curso("Diseño de Interfaces", "CUR011", 2));
        lista.add(new Curso("Arquitectura de Software", "CUR012", 4));
        lista.add(new Curso("Machine Learning", "CUR013", 5));
        lista.add(new Curso("Ética Profesional", "CUR014", 2));
        lista.add(new Curso("Computación en la Nube", "CUR015", 4));

        return lista;
    }
}
