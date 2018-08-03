/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package oop_week3_fractioncalculation;

/**
 *
 * @author TOSHIBA
 */
public class Fraction {

    private int num;
    private int den;

    public Fraction() {

        num = 0;
        den = 1;
    }

    public Fraction(int num, int den) {
        this.num = num;
        this.den = den;
    }

    public String display() {
        String res = num + "/" + den;
        return res;
    }

    public void simplify() {
        Find_UCLN find_UCLN = new Find_UCLN(num, den);
        int temp = find_UCLN.UCLN();
        num /= temp;
        den /= temp;
    }

    public Fraction inverse() {
        return new Fraction(den, num);
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDen() {
        return den;
    }

    public void setDen(int den) {
        this.den = den;
    }

}
