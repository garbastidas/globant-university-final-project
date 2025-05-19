package com.globant.java.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Class {
    // Attributes
    private Teacher teacher;
    private int classroom;
    private List<Student> studentList  = new ArrayList<>();
    private String name;

    // Constructor


    public Class(String name, Teacher teacher, int classroom) {
        this.teacher = teacher;
        this.classroom = classroom;
        this.name = name;
    }

    //Getter and Setter
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public int getClassroom() {
        return classroom;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getStudentList() {
        for(int i = 0; i<studentList.size(); i++){
            studentList.get(i).setIdStudent(i);
            System.out.println(studentList.get(i).getName() + "\t" + studentList.get(i).getIdStudent());
        }
    }

    public void addStudent(Student student){
        studentList.add(student);
    }

    public void printClassInfo(){
        System.out.println("Class: " + this.name);
        System.out.println("Teacher: " + this.teacher.getName());
        System.out.println("Classroom: " + this.classroom);
        getStudentList();
    }
}
