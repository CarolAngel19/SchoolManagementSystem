package org.adaschool.service;

import org.adaschool.entity.Course;
import org.adaschool.entity.Student;
import org.adaschool.exception.StudentAlreadyEnrolledException;
import org.adaschool.exception.StudentNotEnrolledInCourseException;

import java.util.ArrayList;
import java.util.HashMap;

public class AcademicManager implements ServiciosAcademicosI {

    //ArrayList para almacenar estudiantes y cursos
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    // HashMap para mantener la lista de estudiantes inscritos
    private HashMap<Course, ArrayList<Student>> enrolledStudents;


    //Constructor
    public AcademicManager() {
        this.students = new ArrayList<>();
        this.courses = new ArrayList<>();
        this.enrolledStudents = new HashMap<>();
    }

    //Metodos
    @Override
    public void enrollStudent(Student student) {
        if (!students.contains(student)){
            students.add(student);
            System.out.println("Estudiante matriculado exitosamente");
        } else {
            System.out.println("El estudiante ya esta matriculado");
        }
    }


    @Override
    public void addCourse(Course course) {
        if(!courses.contains(course)){
            courses.add(course);
            System.out.println("Curso agregado exitosamente");
        }else {
            System.out.println("El curso ya existe");
        }
    }

    @Override
    public void enrollStudentCourse(Student student, int idCourse) throws StudentAlreadyEnrolledException {
        Course course = findCourseById(idCourse);

        if (course != null) {
            if (enrolledStudents.containsKey(course)) {
                ArrayList<Student> enrolledList = enrolledStudents.get(course);

                if (!enrolledList.contains(student)) {
                    enrolledList.add(student);
                    System.out.println("Estudiante inscrito en el curso correctamente");
                } else {
                    throw new StudentAlreadyEnrolledException("El estudiante ya está inscrito en este curso");
                }
            } else {
                ArrayList<Student> newList = new ArrayList<>();
                newList.add(student);
                enrolledStudents.put(course, newList);
                System.out.println("Estudiante inscrito en el curso correctamente");
            }
        } else {
            System.out.println("Curso no encontrado");
        }
    }

    @Override
    public void unsubscribeStudentCourse(int idStudent, int idCourse) throws StudentNotEnrolledInCourseException {
        Course course = findCourseById(idCourse);

        if (course != null) {
            if (enrolledStudents.containsKey(course)) {
                ArrayList<Student> enrolledList = enrolledStudents.get(course);

                Student studentToRemove = findStudentById(idStudent);

                if (enrolledList.contains(studentToRemove)) {
                    enrolledList.remove(studentToRemove);
                    System.out.println("Estudiante desinscrito del curso");
                } else {
                    throw new StudentNotEnrolledInCourseException("El estudiante no está inscrito en el curso");
                }
            } else {
                throw new StudentNotEnrolledInCourseException("No hay estudiantes inscritos en el curso");
            }
        } else {
            System.out.println("Curso no encontrado");
        }
    }

    //Busca curso o estudiante por ID
    private Course findCourseById(int idCourse) {
        for (Course course : courses) {
            if (course.getId() == idCourse) {
                return course;
            }
        }
        return null;
    }

    private Student findStudentById(int idStudent) {
        for (Student student : students) {
            if (student.getId() == idStudent) {
                return student;
            }
        }
        return null;
    }

}

