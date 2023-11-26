package org.adaschool;

import org.adaschool.entity.Course;
import org.adaschool.entity.Student;
import org.adaschool.exception.StudentAlreadyEnrolledException;
import org.adaschool.exception.StudentNotEnrolledInCourseException;
import org.adaschool.service.AcademicManager;

public class Main {
    public static void main(String[] args) {
        // Crear instancias de Estudiante y Curso
        Student student1 = new Student(1, "Juan", "Gomez", "08/27/1999", "Matriculado");
        Student student2 = new Student(2, "Carol", "Angel", "09/04/2003", "Matriculado");

        Course course1 = new Course(1, "Curso 01", "Curso programacion de Java", 6, "1.0");
        Course course2 = new Course(2, "Curso 02", "Curso programacion de Python", 6, "1.0");

        // Instanciar GestorAcademico
        AcademicManager academicManager = new AcademicManager();

        // Probar inscripción de estudiantes
        academicManager.enrollStudent(student1);
        academicManager.enrollStudent(student2);
        academicManager.enrollStudent(student1); //ya esta matriculado

        // Probar creación de cursos
        academicManager.addCourse(course1);
        academicManager.addCourse(course2);
        academicManager.addCourse(course1); //Ya existe
        System.out.println("-----------------------");

        try {
            academicManager.enrollStudentCourse(student1, 1);
            academicManager.enrollStudentCourse(student1, 1);  // Lanza una excepción
        } catch (StudentAlreadyEnrolledException e) {
            System.out.println(e.getMessage());
        }

        try {
            academicManager.unsubscribeStudentCourse(1, 1);
            academicManager.unsubscribeStudentCourse(2, 1);  // Lanza una excepción
        } catch (StudentNotEnrolledInCourseException e){
            System.out.println(e.getMessage());
        }

    }

}
