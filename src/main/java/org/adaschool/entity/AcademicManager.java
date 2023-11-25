package org.adaschool.entity;

import java.util.ArrayList;
import java.util.HashMap;

public class AcademicManager {

    //ArrayList para almacenar estudiantes y cursos
    private ArrayList<Student> students;
    private ArrayList<Course> courses;

    // HashMap para mantener la lista de estudiantes inscritos
    private HashMap<Course, ArrayList<Student>> enrolledStudents;


    //Constructor
    public AcademicManager(ArrayList<Student> students, ArrayList<Course> courses, HashMap<Course, ArrayList<Student>> enrolledStudents) {
        this.students = students;
        this.courses = courses;
        this.enrolledStudents = enrolledStudents;
    }
}
