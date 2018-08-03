 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

/**
 *
 * @author TOSHIBA
 */
public class Part_Time_Employee extends Employee {

    private int workingHour;
    private float payRate;

    public Part_Time_Employee(int workingHour, float payRate, String ID, String name, int yearBirth, String address, String phoneNumber) {
        super(ID, name, yearBirth, address, phoneNumber);
        this.workingHour = workingHour;
        this.payRate = payRate;
    }

    @Override
    public String getInfo() {
        return ("----------------------------------------------\n"+"Part-time: \n"+"Name: \t\t\t"+super.name+"\n" + "ID: \t\t\t"+super.ID+"\n"+"Address: \t\t"+super.address+"\n"+"Year of birth: \t"+super.yearBirth+"\n"+"Phone number: \t"+super.phoneNumber+"\n"+"Salary: \t\t"+this.getPayment()+"\n----------------------------------------------------");
    }

    @Override
    public float getPayment() {
        return workingHour * payRate;
    }
}
