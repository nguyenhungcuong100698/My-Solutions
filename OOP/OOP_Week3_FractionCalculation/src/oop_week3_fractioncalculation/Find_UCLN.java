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
public class Find_UCLN {

    private int num;
    private int den;

    public Find_UCLN(int num, int den) {
        this.num = num;
        this.den = den;
    }

    public int UCLN() {
        while (num != den) {
            if (num > den) {
                num -= den;
            } else {
                den -= num;
            }
        }
        return num;
    }
}
