package com.globant.java.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class University {
    private List<Class> classes = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    Scanner read = new Scanner(System.in);
    public void printStudents(){
        for (int i = 0; i < students.size() ; i++){
            System.out.println(i + "\t" + students.get(i).getName());
        }
    }
    public void addTeacher(String name, boolean isFullTime){
        if (isFullTime){
            System.out.println("Enter the years of experience: ");
            Teacher teacher = new FullTimeTeacher(name, read.nextInt(), isFullTime);
        } else {
            System.out.println("Enter active hours: ");
            Teacher teacher = new PartTimeTeacher(name, read.nextInt(), isFullTime);
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
        System.out.println("Type the number class to know the basic info or type not");
        //String negativeAnswer = read.nextLine();
        if(read.nextLine().equals("not")){
            return;
        } else {
            int classAsk = read.nextInt();
            submenuClass(classAsk);
        }

    }
    public void newStudent(){
        System.out.print("Type name: ");
        String studentName = read.nextLine();
        System.out.print("Type age: ");
        int studentAge = read.nextInt();
        Student student = new Student(studentName,studentAge);
        students.add(student);
        System.out.println("New student was added");
    }

    public void newClass(){
        printTeachers();
        System.out.println("Select a teacher (type the number)");
        int selectedTeacher = read.nextInt();
        read.nextLine();
        System.out.print("Type name class: ");
        String nameClass = read.nextLine();
        System.out.print("Type classroom (there are classrooms from 100 to 150, assign a number between them): ");
        int currClassroom = read.nextInt();
        Class newClass = new Class(nameClass,teachers.get(selectedTeacher) , currClassroom);
        System.out.println("Add the students from the list, typing the number from the left");
        while(true){
            printStudents();
            int studentID = read.nextInt();
            newClass.addStudent(students.get(studentID));
            System.out.println("Do you want to add another student? Type yes or not");
            read.nextLine();
            String anotherStudent = read.nextLine();
            if (anotherStudent.equals("yes")){
                continue;
            } else if (anotherStudent.equals("not")) {
                break;
            }
        }
        classes.add(newClass);
    }

    public void searchStudent(){
        printStudents();
        System.out.println("Select a student id to know what courses are their in");
        int studentID = read.nextInt();
        Student currStudent = students.get(studentID);
        List<Class> studentClasses = new ArrayList<>();
        System.out.println("The student " + currStudent.getName() + " is subscribed to the following classes: ");
        for(Class clas_s: classes){
            for(Student student: clas_s.getStudent_List()){
                if(student.equals(currStudent)){
                    System.out.println(clas_s.getName() + " " + clas_s.getClassroom());
                }
            }
        }
    }

}
