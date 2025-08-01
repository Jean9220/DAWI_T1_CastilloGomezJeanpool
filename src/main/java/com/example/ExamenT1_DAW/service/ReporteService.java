package com.example.ExamenT1_DAW.service;

import com.example.ExamenT1_DAW.entity.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.time.LocalDate;


public class ReporteService {

    private EntityManager em;

    public ReporteService(EntityManager em) {
        this.em = em;
    }

    // a) JOIN y agregación
    public void cursosConTotalesYPromedioCreditos() {
        System.out.println("\n--- CURSOS CON +2 INSCRIPCIONES Y PROMEDIO DE CRÉDITOS ---");

        String jpql = """
            SELECT c.nombre, COUNT(i.id), AVG(c.creditos)
            FROM Curso c JOIN c.inscripcion i
            GROUP BY c.id
            HAVING COUNT(i.id) >= 2
        """;

        List<Object[]> resultados = em.createQuery(jpql, Object[].class).getResultList();

        for (Object[] fila : resultados) {
            System.out.printf("Curso: %-30s | Inscripciones: %-2s | Promedio Créditos: %.2f\n",
                    fila[0], fila[1], fila[2]);

        }
    }

    // b) Subconsulta: estudiantes en más de 2 cursos
    public void estudiantesConMasDeDosCursos() {
        System.out.println("\n--- ESTUDIANTES EN MÁS DE 2 CURSOS ---");

        String jpql = """
            SELECT e.nombre, e.email, COUNT(i.id)
            FROM Estudiante e JOIN e.inscripcion i
            GROUP BY e.id, e.nombre, e.email
            HAVING COUNT(i.id) > 2
        """;

        List<Object[]> resultados = em.createQuery(jpql, Object[].class).getResultList();

        for (Object[] fila : resultados) {
            System.out.printf("Estudiante: %-25s | Email: %-25s | Cursos Inscritos: %s\n",
                    fila[0], fila[1], fila[2]);
        }
    }

    // c) Filtros dinámicos por fecha, estado, nombre y código
    public void buscarInscripciones(LocalDate desde, LocalDate hasta, Inscripcion.EstadoInscripcion estado,
                                    String nombreEstudiante, String codigoCurso) {
        System.out.println("\n--- INSCRIPCIONES FILTRADAS ---");

        StringBuilder jpql = new StringBuilder("""
            SELECT i FROM Inscripcion i
            WHERE i.fechaInscripcion BETWEEN :desde AND :hasta
            AND i.estado = :estado
        """);

        if (nombreEstudiante != null && !nombreEstudiante.isBlank()) {
            jpql.append(" AND i.estudiante.nombre LIKE :nombre ");
        }

        if (codigoCurso != null && !codigoCurso.isBlank()) {
            jpql.append(" AND i.curso.codigo = :codigo ");
        }

        jpql.append(" ORDER BY i.fechaInscripcion DESC");

        TypedQuery<Inscripcion> query = em.createQuery(jpql.toString(), Inscripcion.class);
        query.setParameter("desde", desde);
        query.setParameter("hasta", hasta);
        query.setParameter("estado", estado);

        if (nombreEstudiante != null && !nombreEstudiante.isBlank()) {
            query.setParameter("nombre", "%" + nombreEstudiante + "%");
        }

        if (codigoCurso != null && !codigoCurso.isBlank()) {
            query.setParameter("codigo", codigoCurso);
        }

        List<Inscripcion> resultados = query.getResultList();

        for (Inscripcion i : resultados) {
            System.out.printf("ID: %d | Fecha: %s | Estado: %s | Estudiante: %s | Curso: %s\n",
                    i.getId(), i.getFechaIncripcion(), i.getEstado(),
                    i.getEstudiante().getNombre(), i.getCurso().getNombre());
        }

        if (resultados.isEmpty()) {
            System.out.println("Sin resultados para los filtros aplicados.");
        }
    }

    // d) Reporte complejo: carga académica de profesores
    public void reporteCargaAcademicaProfesores() {
        System.out.println("\n--- CARGA ACADÉMICA DE PROFESORES ---");

        String jpql = """
            SELECT p.nombre, SUM(c.creditos)
            FROM Profesor p JOIN p.cursos c
            GROUP BY p.id, p.nombre
            HAVING COUNT(c.id) > 0
        """;

        List<Object[]> resultados = em.createQuery(jpql, Object[].class).getResultList();

        for (Object[] fila : resultados) {
            System.out.printf("Profesor: %-25s | Créditos Totales: %s\n", fila[0], fila[1]);
        }
    }
}
