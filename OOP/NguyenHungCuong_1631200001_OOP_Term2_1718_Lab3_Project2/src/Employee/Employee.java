package Employee;

import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TOSHIBA
 */
public abstract class Employee implements Serializable{
    protected final String ID;
    protected final String name;
    protected final int yearBirth;
    protected final String address;
    protected final String phoneNumber;

    public Employee(String ID, String name, int yearBirth, String address, String phoneNumber) {
        this.ID = ID;
        this.name = name;
        this.yearBirth = yearBirth;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
    public abstract String getInfo();
    public abstract float getPayment();

    public String getID() {
        return ID;
    }
    
}
