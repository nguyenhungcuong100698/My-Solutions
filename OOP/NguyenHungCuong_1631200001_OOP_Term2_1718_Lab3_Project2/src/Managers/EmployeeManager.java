/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Managers;

import Employee.Full_Time_Employee;
import Employee.Part_Time_Employee;
import dao.HRDao;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author TOSHIBA
 */
public class EmployeeManager {

    HRDao myDao;
    ArrayList<Employee.Employee> myEmployee;
    Scanner scan;

    public EmployeeManager() {
        myDao = new HRDao();
        myEmployee = new ArrayList<>();
        scan = new Scanner(System.in);
    }
    public void saving(){
        this.myDao.saveAsByte(myEmployee);
    }
    public int restore() {
        this.myEmployee = this.myDao.readByte();
        return this.myEmployee.size();
    }

    public void addPartTimeEmployee(int workingHour, float payRate, String ID, String name, int yearBirth, String address, String phoneNumber) {
        myEmployee.add(new Part_Time_Employee(workingHour, payRate, ID, name, yearBirth, address, phoneNumber));
    }

    public void addFullTimeEmployee(float salary, String ID, String name, int yearBirth, String address, String phoneNumber) {
        myEmployee.add(new Full_Time_Employee(salary, ID, name, yearBirth, address, phoneNumber));
    }

    public ArrayList showAll(int a) {
        ArrayList<Employee.Employee> res = new ArrayList<>();
        if (a == 1) {
            for (Employee.Employee fulltime : myEmployee) {
                if (fulltime instanceof Full_Time_Employee) {
                    res.add(fulltime);
                }
            }
        } else if (a == -1) {
            for (Employee.Employee parttime : myEmployee) {
                if (parttime instanceof Part_Time_Employee) {
                    res.add(parttime);
                }
            }
        } else {
            return myEmployee;
        }
        return res;
    }

    public Employee.Employee searchID(String ID) {
        for (Employee.Employee employee1 : myEmployee) {
            if (employee1.getID().equals(ID)) {
                return employee1;
            }
        }
        return null;
    }

    public void deleteID(Employee.Employee temp) {
        myEmployee.remove(temp);
    }

    public ArrayList<Employee.Employee> searchPayment(float from, float to) {
        ArrayList<Employee.Employee> res = new ArrayList<>();
        for (Employee.Employee employee : myEmployee) {
            if (employee.getPayment() >= from && employee.getPayment() <= to) {
                res.add(employee);
            }
        }
        return res;
    }
}
