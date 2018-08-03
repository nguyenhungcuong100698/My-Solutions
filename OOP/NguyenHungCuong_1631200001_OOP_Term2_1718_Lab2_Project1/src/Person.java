/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOSHIBA
 */
public class Person {

    private String name;
    private String address;
    private String nationality;
    private String gender;
    private String qualification;
    private String mariatalStatus;
    private int yearOfBirth;

    public Person(String name, String address, String nationality, String gender, String qualification, String mariatalStatus, int yearOfBirth) {
        this.name = name;
        this.address = address;
        this.nationality = nationality;
        this.gender = gender;
        this.qualification = qualification;
        this.mariatalStatus = mariatalStatus;
        this.yearOfBirth = yearOfBirth;
    }

    public void display() {
        System.out.println("Name: \t\t\t" + name);
        System.out.println("Address: \t\t" + address);
        System.out.println("Nationality: \t\t" + nationality);
        System.out.println("Gender: \t\t" + gender);
        System.out.println("Year of birth: \t\t" + yearOfBirth);
        System.out.println("Qualification: \t\t" + qualification);
        System.out.println("Mariatal Status: \t" + mariatalStatus);
    }

}
