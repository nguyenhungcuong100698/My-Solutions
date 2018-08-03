
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TOSHIBA
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Enter your name: ");
        String name = scan.next();
        
        
        System.out.println("Enter your address: ");
        String address = scan.next();
        
        
        System.out.println("Enter your nationality: ");
        String nationality = scan.next();
        
        
        System.out.println("Enter your gender: ");
        String gender = scan.next();
        
        
        System.out.println("Enter your year of birth: ");
        int yearOfBirth = scan.nextInt();
        
        
        System.out.println("Enter your qualification: ");
        String qualification = scan.next();
        
        
        System.out.println("Enter your mariatal status: ");
        String mariatalStatus = scan.next();
        
        Person user = new Person(name, address, nationality, gender, qualification, mariatalStatus, yearOfBirth);
        user.display();
    }
}
