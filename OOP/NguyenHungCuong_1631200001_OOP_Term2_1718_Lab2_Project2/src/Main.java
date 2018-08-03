
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
        System.out.print("Enter your major: ");
        String major = scan.next();
        System.out.print("Enter your lisence ID: ");
        int lisenceID = scan.nextInt();
        Person driver = new Driver(lisenceID);
        driver.showJob();
        Person teacher = new Teacher(major);
        teacher.showJob();
    }
}
