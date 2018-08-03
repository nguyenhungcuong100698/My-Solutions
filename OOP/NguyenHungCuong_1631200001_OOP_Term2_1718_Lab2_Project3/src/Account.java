
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
public class Account {

    Scanner scan = new Scanner(System.in);
    private double balance;

    public Account() {
        balance = 0;
    }

    public void deposit() {
        System.out.print("Enter your amount: ");
        double moneyIn = scan.nextDouble();
        if (moneyIn > 0) {
            balance += moneyIn;
            System.out.println("Successful");
        } else {
            System.out.println("Unsuccessful");
        }
    }

    public void withdraw() {
        System.out.print("Enter your amount: ");
        double moneyOut = scan.nextDouble();
        if (moneyOut > 0 && moneyOut <= balance) {
            balance -= moneyOut;
            System.out.println("Successful");
        } else {
            System.out.println("Unsuccessful");
        }
    }

    public double getBalance() {
        return balance;
    }

}
