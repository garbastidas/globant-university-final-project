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
