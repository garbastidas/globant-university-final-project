package com.globant.java.models;

public class FullTimeTeacher extends Teacher{
    private final int yearsExperience;

    public FullTimeTeacher(String name, int yearsExperience, boolean isFullTime) {
        setFullTime(isFullTime);
        setName(name);
        this.yearsExperience = yearsExperience;
    }

    public double salary(){
        return getBaseSalary()*1.1*this.yearsExperience;
    }
}
