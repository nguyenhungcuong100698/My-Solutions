/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;

/**
 *
 * @author Duong
 */
public class Student implements Serializable{
    private String holyName;
    private String firstName;
    private String lastName;
    private String schoolStage;
    private String stuClass;
    private String yearOfBirth;
    private String placeOfBirth;
    private String fatherName;
    private String motherName;
    private String phoneNumber;
    private String address;
    private int mieng = 0;
    private int muoilam = 0;
    private int mottiet = 0;
    private int thi = 0;
    

    public Student(String holyName, String firstName, String lastName, String schoolStage, String stuClass, String yearOfBirth, String placeOfBirth, String fatherName, String motherName, String phoneNumber, String address) {
        this.holyName = holyName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.schoolStage = schoolStage;
        this.stuClass = stuClass;
        this.yearOfBirth = yearOfBirth;
        this.placeOfBirth = placeOfBirth;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getHolyName() {
        return holyName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getSchoolStage() {
        return schoolStage;
    }

    public String getStuClass() {
        return stuClass;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getPlaceOfBirth() {
        return placeOfBirth;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public int getMieng() {
        return mieng;
    }

    public int getMuoilam() {
        return muoilam;
    }

    public int getMottiet() {
        return mottiet;
    }

    public int getThi() {
        return thi;
    }

    public void setHolyName(String holyName) {
        this.holyName = holyName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setSchoolStage(String schoolStage) {
        this.schoolStage = schoolStage;
    }

    public void setStuClass(String stuClass) {
        this.stuClass = stuClass;
    }

    public void setYearOfBirth(String yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public void setPlaceOfBirth(String placeOfBirth) {
        this.placeOfBirth = placeOfBirth;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setMotherName(String motherName) {
        this.motherName = motherName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setMieng(int mieng) {
        this.mieng = mieng;
    }

    public void setMuoilam(int muoilam) {
        this.muoilam = muoilam;
    }

    public void setMottiet(int mottiet) {
        this.mottiet = mottiet;
    }

    public void setThi(int thi) {
        this.thi = thi;
    }
    
   
    }
