/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class Lesson implements Serializable{
    private int schoolStage;
    private String grade;
    private String date;
    private String unit;
    private String name;

    public Lesson(int schoolStage, String grade, String date, String unit, String name) {
        this.schoolStage = schoolStage;
        this.grade = grade;
        this.date = date;
        this.unit = unit;
        this.name = name;
    }

    public int getSchoolStage() {
        return schoolStage;
    }

    public void setSchoolStage(int schoolStage) {
        this.schoolStage = schoolStage;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
