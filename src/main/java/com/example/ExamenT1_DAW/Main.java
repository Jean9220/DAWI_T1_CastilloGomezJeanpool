package com.example.ExamenT1_DAW;

import com.example.ExamenT1_DAW.entity.Curso;
import com.example.ExamenT1_DAW.entity.Estudiante;
import com.example.ExamenT1_DAW.entity.Inscripcion;
import com.example.ExamenT1_DAW.entity.Profesor;
import com.example.ExamenT1_DAW.service.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            EstudianteService estudianteService = new EstudianteService();
            CursoService cursoService = new CursoService();
            ProfesorService profesorService = new ProfesorService();
            InscripcionService inscripcionService = new InscripcionService();

            List<Estudiante> estudiantes = estudianteService.crearEstudiantesPrueba();
            List<Curso> cursos = cursoService.crearCursosPrueba();
            List<Profesor> profesores = profesorService.crearProfesoresPrueba();
            List<Inscripcion> inscripciones = inscripcionService.crearInscripciones(estudiantes, cursos);

            tx.begin();
            for (Estudiante e : estudiantes) {
                em.persist(e);
            }
            for (Curso c : cursos) {
                em.persist(c);
            }
            for (int i = 0; i < profesores.size(); i++) {
                Profesor prof = profesores.get(i);
                List<Curso> cursosAsignados = new ArrayList<>();
                cursosAsignados.add(cursos.get(i % cursos.size()));
                cursosAsignados.add(cursos.get((i + 1) % cursos.size()));
                prof.setCursos(cursosAsignados);
            }
            for (Profesor p : profesores) {
                em.persist(p);
            }
            for (Profesor p : profesores) {
                em.persist(p);
            }
            for (Inscripcion i : inscripciones) {
                em.persist(i);
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }

        ReporteService reporteService = new ReporteService(em);

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- MENÚ DE REPORTES ---");
            System.out.println("1. Ver cursos con inscripciones y promedio");
            System.out.println("2. Ver estudiantes con +2 cursos");
            System.out.println("3. Filtrar inscripciones");
            System.out.println("4. Ver carga académica de profesores");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> reporteService.cursosConTotalesYPromedioCreditos();
                case 2 -> reporteService.estudiantesConMasDeDosCursos();
                case 3 -> {
                    System.out.print("Desde (YYYY-MM-DD): ");
                    LocalDate desde = LocalDate.parse(sc.nextLine());

                    System.out.print("Hasta (YYYY-MM-DD): ");
                    LocalDate hasta = LocalDate.parse(sc.nextLine());

                    System.out.print("Estado (PENDIENTE, CONFIRMADA, CANCELADA): ");
                    Inscripcion.EstadoInscripcion estado = Inscripcion.EstadoInscripcion.valueOf(sc.nextLine());

                    System.out.print("Estudiante (opcional): ");
                    String nombre = sc.nextLine();

                    System.out.print("Código de curso (opcional): ");
                    String codigo = sc.nextLine();

                    reporteService.buscarInscripciones(desde, hasta, estado, nombre, codigo);
                }
                case 4 -> reporteService.reporteCargaAcademicaProfesores();
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción inválida");
            }
        } while (opcion != 0);

        em.close();
        emf.close();
    }
}