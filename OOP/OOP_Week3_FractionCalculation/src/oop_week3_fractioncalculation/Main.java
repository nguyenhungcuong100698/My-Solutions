/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_week3_fractioncalculation;

import java.util.Scanner;

/**
 *
 * @author TOSHIBA
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Fraction myFraction = new Fraction();
        InputClass inputclass = new InputClass();
        do {
            myFraction = inputclass.inputNumber();
            if (inputclass.checkfalse()) {
                System.out.println("Invalid Input");
                continue;
            }
            break;
        } while (true);

        while (true) {
            System.out.println("Choose what you want to do: ");
            System.out.println("1. Show the fraction ");
            System.out.println("2. Simplify the fraction ");
            System.out.println("3. Inverse the fraction ");
            System.out.println("4. Addition ");
            System.out.println("5. Abtraction ");
            System.out.println("6. Multiplying ");
            System.out.println("7. Dividing ");
            System.out.println("8. Exist");
            System.out.println("Enter your choice: ");
            int choice = scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Your fraction is: " + myFraction.display());
                    break;
                case 2:
                    myFraction.simplify();
                    System.out.println("Successful: " + myFraction.display());
                    break;
                case 3:
                    if (myFraction.inverse().getDen() == 0) {
                        System.out.println("Unsuccessful/nInvalid fraction");
                    } else {
                        System.out.println("Successful: " + myFraction.inverse().display());
                    }
                    break;
                case 4:
                    System.out.println("Enter the other fraction: ");
                    Fraction addFraction = inputclass.inputNumber();
                    if (inputclass.checkfalse()) {
                        System.out.println("Unsuccessful");
                    } else {
                        FractionOperator addResult = new FractionOperator();
                        System.out.println("Successful: " + addResult.addition(myFraction, addFraction).display());
                    }
                    break;
                case 5:
                    System.out.println("Enter the other fraction: ");
                    Fraction abFraction = inputclass.inputNumber();
                    if (inputclass.checkfalse()) {
                        System.out.println("Unsuccessful");
                    } else {
                    FractionOperator abResult = new FractionOperator();
                    System.out.println("Successful: " + abResult.abtraction(myFraction, abFraction).display());
                    }
                    break;
                case 6:
                    System.out.println("Enter the other fraction: ");
                    Fraction mulFraction = inputclass.inputNumber();
                    if (inputclass.checkfalse()) {
                        System.out.println("Unsuccessful");
                    } else {
                    FractionOperator mulResult = new FractionOperator();
                    System.out.println("Successful: " + mulResult.multiply(myFraction, mulFraction).display());
                    }
                    break;
                case 7:
                    System.out.println("Enter the other fraction: ");
                    Fraction divFraction = inputclass.inputNumber();
                    if (divFraction.getNum()==0) {
                        System.out.println("Unsuccessful");
                    } else {
                    FractionOperator divResult = new FractionOperator();
                    System.out.println("Successful: " + divResult.multiply(myFraction, divFraction.inverse()).display());
                    }
                    break;
                default:
                    break;
            }
            if (choice == 8) {
                break;
            }
        }
    }

}
