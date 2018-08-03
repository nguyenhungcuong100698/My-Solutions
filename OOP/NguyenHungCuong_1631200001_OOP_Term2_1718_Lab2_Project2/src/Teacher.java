/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOSHIBA
 */
public class Teacher extends Person{

    private String major;

    public Teacher(String major) {
        this.major = major;
    }

    

    
    
    public void showJob() {
        System.out.println("Your major is: "+major);
    }
    
}
