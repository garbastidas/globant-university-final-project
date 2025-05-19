package com.globant.java.models;

public class PartTimeTeacher extends Teacher{
    private final double activeHours;

    public PartTimeTeacher(String name, double activeHours, boolean isFullTime) {
        setFullTime(isFullTime);
        setName(name);
        this.activeHours = activeHours;
        setBaseSalary(salary());
    }
    // I'm going to assume that a teacher works 40 hours per week

    public double salary(){
        return getBaseSalary()*this.activeHours/40.0;
    }
}
