package com.globant.java.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class University {
    private List<Class> classes = new ArrayList<>();
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();

    Scanner read = new Scanner(System.in);

    public University() {
        // Professors
        Teacher teacher1 = new FullTimeTeacher("Fernando", 3, true);
        Teacher teacher2 = new PartTimeTeacher("Hernando", 20, false);
        List<Teacher> teachers_s = new ArrayList<>();
        teachers_s.add(teacher1); teachers_s.add(teacher2);
        // Students
        Student student1 = new Student("Javier", 22);
        Student student2 = new Student("María", 21);
        Student student3 = new Student("Juan", 22);
        Student student4 = new Student("Jazmín", 23);
        Student student5 = new Student("Ricardo", 22);
        Student student6 = new Student("Azucena", 20);
        List<Student> students_s = new ArrayList<>();
        students_s.add(student1);students_s.add(student2);students_s.add(student3);
        students_s.add(student4);students_s.add(student5);students_s.add(student6);
        // Classes
        Class class1 = new Class("Biology", teacher1, 101);
        Class class2 = new Class("Biochemistry", teacher1, 102);
        Class class3 = new Class("Calculus I", teacher2, 103);
        Class class4 = new Class("Calculus II", teacher2, 104);
        for(Student student: students_s){
            class1.addStudent(student);
            class2.addStudent(student);
            class3.addStudent(student);
            class4.addStudent(student);
        }
        List<Class> classes_s = new ArrayList<>();
        classes_s.add(class1); classes_s.add(class2); classes_s.add(class3); classes_s.add(class4);
        setStudents(students_s);
        setTeachers(teachers_s);
        setClasses(classes_s);
    }

    public void setClasses(List<Class> classes) {
        this.classes = classes;
    }

    public void setTeachers(List<Teacher> teachers) {
        this.teachers = teachers;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void printStudents(){
        for (int i = 0; i < students.size() ; i++){
            System.out.println(i + "\t" + students.get(i).getName());
        }
    }

    public void printTeachers(){
        for (int i = 0; i < teachers.size() ; i++){
            String typeTeacher = teachers.get(i).isFullTime() ? "Full time": "Part time";
            System.out.println(i + "\t" + teachers.get(i).getName() +
                    "\t" + teachers.get(i).getBaseSalary() + " " + typeTeacher);
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
