package com.globant.java.principal;

import com.globant.java.models.*;
import com.globant.java.models.Class;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        // University
        University university = new University();
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
        university.setStudents(students_s);
        university.setTeachers(teachers_s);
        university.setClasses(classes_s);
        //Begining Menu
        System.out.println("a. Professors");
        System.out.println("b. Classes");
        System.out.println("c. New Student");
        System.out.println("d. New Class");
        System.out.println("e. Search student");
        System.out.println("f. Exit");
        while(true){
            String letter = read.nextLine();
            if(letter.equals("f")){
                break;
            }else {
                switch (letter) {
                    case "a":
                        university.printTeachers();
                        break;
                    case "b":
                        university.printClasses();
                        break;
                    case "c":
                        university.newStudent();
                        break;
                    case "d":
                        university.newClass();
                        break;
                    case "e":
                        university.searchStudent();
                        break;
                    default:
                        System.out.println("a. Professors");
                        System.out.println("b. Classes");
                        System.out.println("c. New Student");
                        System.out.println("d. New Class");
                        System.out.println("e. Search student");
                        System.out.println("f. Exit");
                        break;
                }
            }
        }

    }
}
