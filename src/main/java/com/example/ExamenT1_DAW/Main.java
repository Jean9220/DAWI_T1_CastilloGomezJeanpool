package com.example.ExamenT1_DAW;

import com.example.ExamenT1_DAW.entity.Curso;
import com.example.ExamenT1_DAW.entity.Estudiante;
import com.example.ExamenT1_DAW.entity.Profesor;
import com.example.ExamenT1_DAW.service.CursoService;
import com.example.ExamenT1_DAW.service.EstudianteService;
import com.example.ExamenT1_DAW.service.ProfesorService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("GestionPU");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            EstudianteService estudianteService = new EstudianteService();
            CursoService cursoService = new CursoService();
            ProfesorService profesorService = new ProfesorService();

            List<Estudiante> estudiantes = estudianteService.crearEstudiantesPrueba();
            List<Curso> cursos = cursoService.crearCursosPrueba();
            List<Profesor> profesores = profesorService.crearProfesoresPrueba();

            tx.begin();

            for (Estudiante e : estudiantes) {
                em.persist(e);
            }

            for (Curso c : cursos) {
                em.persist(c);
            }

            for (Profesor p : profesores) {
                em.persist(p);
            }

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }

    }
}
