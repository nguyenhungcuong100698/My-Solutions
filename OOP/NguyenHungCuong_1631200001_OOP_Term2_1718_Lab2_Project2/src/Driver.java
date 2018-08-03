/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOSHIBA
 */
public class Driver extends Person{
    private int lisienceID;

    public Driver(int lisienceID) {
        this.lisienceID = lisienceID;
    }

    

    
    
    public void showJob() {
        System.out.println("Your lisience ID is: "+lisienceID);
    }
    
}
