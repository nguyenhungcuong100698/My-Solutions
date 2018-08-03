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
public class InputClass {

    private int num;
    private int den;
    Scanner scan = new Scanner(System.in);

    public InputClass() {
        num = 0;
        den = 1;
    }

    public boolean checkfalse() {
        return (den == 0);
    }

    public Fraction inputNumber() {
        Fraction temp = new Fraction();
        System.out.println("Enter the numerator: ");
        temp.setNum(scan.nextInt());
        num = temp.getNum();
        System.out.println("Enter the denonator: ");
        temp.setDen(scan.nextInt());
        den = temp.getDen();
        return temp;
    }

    public int getNum() {
        return num;
    }

    public int getDen() {
        return den;
    }

}
