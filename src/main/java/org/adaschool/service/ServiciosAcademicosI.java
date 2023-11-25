package org.adaschool.service;

import org.adaschool.entity.Course;
import org.adaschool.entity.Student;
import org.adaschool.exception.StudentAlreadyEnrolledException;
import org.adaschool.exception.StudentNotEnrolledInCourseException;

public interface ServiciosAcademicosI {
    void enrollStudent(Student student);
    void addCourse(Course course);
    void enrollStudentCourse(Student student, int idCurso) throws StudentAlreadyEnrolledException;;
    void unsubscribeStudentCourse(int idEstudiante, int idCurso) throws StudentNotEnrolledInCourseException;
}

