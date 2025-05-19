package com.globant.java.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class University {
    private List<Class> classes = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private boolean isCallSubmenu = false;

    Scanner read = new Scanner(System.in);
    public void printStudents(){
        for (int i = 0; i < students.size() ; i++){
            System.out.println(i + "\t" + students.get(i).getName());
        }
    }
    public void printTeachers(){
        for (int i = 0; i < teachers.size() ; i++){
            String typeTeacher = teachers.get(i).isFullTime() ? "Full time": "Part time";
            System.out.println(i + "\t" + teachers.get(i).getName() +
                    "\t" + teachers.get(i).getBaseSalary() + typeTeacher);
        }
    }
    private void submenuClass(int classAsk){
        classes.get(classAsk).printClassInfo();
    }

    public void printClasses() {
        for (int i = 0; i < classes.size() ; i++){
            System.out.println(i + "\t" +  classes.get(i).getName());
        }
        System.out.println("Type the number class to know the basic info");
        int classAsk = read.nextInt();
        submenuClass(classAsk);

    }
    public void newStudent(){
        System.out.println("Type name and age student");
        Student student = new Student(read.nextLine(),read.nextInt());
    }

    public void newClass(){
        printTeachers();
        System.out.println("Select a teacher (type the number)");
        int selectedTeacher = read.nextInt();
        System.out.println("Type name and classroom (there are classrooms from 100 to 150, assign a number between them)");
        Class newClass = new Class(read.nextLine(),teachers.get(selectedTeacher) , read.nextInt());
        System.out.println("Add the students from the list, typing the number to the left");
        printStudents();
        while(true){
            newClass.addStudent(students.get(read.nextInt()));
            System.out.println("Do you want to add another student? Type yes or not");
            String anotherStudent = read.nextLine();
            if (anotherStudent.equals("yes")){
                continue;
            } else if (anotherStudent.equals("not")) {
                System.out.println();
                break;
            }
        }
    }

    public static void exit(){
        System.out.println("Type F to exit");
    }
}
