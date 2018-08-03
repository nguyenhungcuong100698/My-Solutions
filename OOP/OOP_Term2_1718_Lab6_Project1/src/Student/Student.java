/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

import java.io.Serializable;

/**
 *
 * @author LENOVO
 */
public class Student implements Serializable{
    private String id;
    private String lastName;
    private String midName;
    private String firstName;
    private int yearOfBirth;
    private String gender;//mall or female
    private String shoolStage;//elementary School,Middle School, High School

    public Student(String id, String lastName, String midName, String firstName, int yearOfBirth, String gender, String shoolStage) {
        this.id = id;
        this.lastName = lastName;
        this.midName = midName;
        this.firstName = firstName;
        this.yearOfBirth = yearOfBirth;
        this.gender = gender;
        this.shoolStage = shoolStage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getShoolStage() {
        return shoolStage;
    }

    public void setShoolStage(String shoolStage) {
        this.shoolStage = shoolStage;
    }
    
    
}
