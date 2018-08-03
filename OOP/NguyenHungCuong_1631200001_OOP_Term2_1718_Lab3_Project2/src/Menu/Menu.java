/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import Employee.Full_Time_Employee;
import Employee.Part_Time_Employee;
import Managers.EmployeeManager;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author TOSHIBA
 */
public class Menu {

    Scanner scan;
    EmployeeManager myManager;

    public Menu() {
        myManager = new EmployeeManager();
        scan = new Scanner(System.in);
    }

    public void displayMneu() {
        int choice;
        do {
            printMenu();
            choice = scan.nextInt();
            switch (choice) {
                case 0:
                    this.displayRestore();
                    break;
                case 1:
                    this.displayAdd(true);
                    break;
                case 2:
                    this.displayAdd(false);
                    break;
                case 3:
                    this.displayAllFull();
                    break;
                case 4:
                    this.displayAllPart_time();
                    break;
                case 5:
                    this.displayAll();
                    break;
                case 6:
                    this.displaysearchByID();
                    break;
                case 7:
                    this.displayDeleteByID();
                    break;
                case 8:
                    this.displayEdit();
                    break;
                case 9:
                    this.displaySearchPayment();
                    break;
                default:
                    break;
            }
            if (choice == 10) {
                System.out.println("Do you want to save the data?");
                if (scan.next().equalsIgnoreCase("YES")) {
                    this.myManager.saving();
                }
            }
        } while (choice != 10);
    }

    public void displayRestore() {
        System.out.println("Restore sucessful, there are " + this.myManager.restore() + " objects.");
    }

    public void displaySearchPayment() {
        System.out.print("You want to search from: ");
        float from = scan.nextFloat();
        System.out.print(" to ");
        float to = scan.nextFloat();
        ArrayList<Employee.Employee> res = this.myManager.searchPayment(from, to);
        for (Employee.Employee employee1 : res) {
            System.out.println(employee1.getInfo());
        }
    }

    private void displayAdd(boolean a) {
        System.out.print("Enter the ID: ");
        String ID = scan.next();
        System.out.print("Enter the name: ");
        String name = scan.next();
        System.out.print("Enter the year of birth: ");
        int yearBirth = scan.nextInt();
        System.out.print("Enter the address: ");
        String address = scan.next();
        System.out.print("Enter the phone number: ");
        String phoneNumber = scan.next();
        if (a) {
            System.out.print("Enter the salary: ");
            float salary = scan.nextFloat();
            this.myManager.addFullTimeEmployee(salary, ID, name, yearBirth, address, phoneNumber);
        } else {
            System.out.print("Enter the working hour: ");
            int workingHour = scan.nextInt();
            System.out.print("Enter the pay rate: ");
            float payRate = scan.nextFloat();
            this.myManager.addPartTimeEmployee(workingHour, payRate, ID, name, yearBirth, address, phoneNumber);
        }

        System.out.println("Sucessful");
    }

    private void displayAllFull() {
        ArrayList<Full_Time_Employee> employee = this.myManager.showAll(1);
        for (Full_Time_Employee employee1 : employee) {
            System.out.println(employee1.getInfo());
        }
    }

    private void displayAllPart_time() {
        ArrayList<Part_Time_Employee> employee = this.myManager.showAll(-1);
        for (Part_Time_Employee employee1 : employee) {
            System.out.println(employee1.getInfo());
        }
    }

    private void displayAll() {
        this.displayAllFull();
        this.displayAllPart_time();
    }

    private void displaysearchByID() {
        System.out.println("Enter the ID: ");
        String tempInput = scan.next();
        Employee.Employee res = this.myManager.searchID(tempInput);
        if (res != null) {
            System.out.println("Sucessful");
            System.out.println(res.getInfo());
        } else {
            System.out.println("Unsucessful");
        }
    }

    private void displayDeleteByID() {
        System.out.println("Enter the ID: ");
        String tempInput = scan.next();
        Employee.Employee res = this.myManager.searchID(tempInput);
        if (res != null) {
            System.out.println(res.getInfo());
            System.out.print("Enter YES to confirm: ");
            if (scan.next().equalsIgnoreCase("YES")) {
                this.myManager.deleteID(res);
                System.out.println("Deleted");
            }
        } else {
            System.out.println("Unsucessful\nCannot find employee");
        }
    }

    public void displayEdit() {
        System.out.println("Enter the ID");
        String tempID = scan.next();
        Employee.Employee temp = this.myManager.searchID(tempID);
        if (temp instanceof Full_Time_Employee) {
            Full_Time_Employee fulltime = (Full_Time_Employee) temp;
            System.out.println(fulltime.getInfo());
            System.out.println("-----------------------------------------");
            System.out.println("Enter the new infomation");
            System.out.println("1. Name");
            String newName = scan.next();
            System.out.println("2. Year of birth");
            int newYear = scan.nextInt();
            System.out.println("3. Phone number");
            String newNumber = scan.next();
            System.out.println("4. Salary");
            float newSalary = scan.nextFloat();
            System.out.println("5. Address");
            String newAddress = scan.next();
            System.out.println("-----------------------------------------");
            this.myManager.addFullTimeEmployee(newSalary, tempID, newName, newYear, newAddress, newNumber);
            System.out.println("Suceesful");
        } else {
            Part_Time_Employee parttime = (Part_Time_Employee) temp;
            System.out.println(parttime.getInfo());
            System.out.println("-----------------------------------------");
            System.out.println("Enter the new infomation");
            System.out.println("1. Name ");
            String newName = scan.next();
            System.out.println("2. Year of birth ");
            int newYear = scan.nextInt();
            System.out.println("3. Phone number ");
            String newNumber = scan.next();
            System.out.println("4. Address ");
            String newAddress = scan.next();
            System.out.println("5. Working hour ");
            int newHour = scan.nextInt();
            System.out.println("6. Pay rate ");
            int newRate = scan.nextInt();
            System.out.println("-----------------------------------------");
            this.myManager.addPartTimeEmployee(newHour, newRate, tempID, newName, newYear, newAddress, newNumber);
            System.out.println("Suceesful");
        }
    }

    private void printMenu() {
        System.out.println("---------------------------------------");
        System.out.println("0. Restore data from file");
        System.out.println("1. Add Full-time employee");
        System.out.println("2. Add Part-time employee");
        System.out.println("3. Show all Full-time employee");
        System.out.println("4. Show all Part-time employee");
        System.out.println("5. Show all employee");
        System.out.println("6. Search employee by ID");
        System.out.println("7. Delete employee by ID");
        System.out.println("8. Edit employee information by ID");
        System.out.println("9. Search employee by payment");
        System.out.println("10. Exit");
        System.out.println("What do you want?");
        System.out.println("---------------------------------------");
    }
}
