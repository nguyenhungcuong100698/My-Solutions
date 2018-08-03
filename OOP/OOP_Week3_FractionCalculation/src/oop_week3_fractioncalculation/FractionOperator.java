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
public class FractionOperator {

    public Fraction addition(Fraction f1, Fraction f2) {
        Fraction res = new Fraction();
        res.setNum(f1.getNum() * f2.getDen() + f2.getNum() * f1.getDen());
        res.setDen(f1.getDen() * f2.getDen());
        res.simplify();
        return res;
    }

    public Fraction abtraction(Fraction f1, Fraction f2) {
        Fraction res = new Fraction();
        res.setNum(f1.getNum() * f2.getDen() - f2.getNum() * f1.getDen());
        res.setDen(f1.getDen() * f2.getDen());
        res.simplify();
        return res;
    }

    public Fraction multiply(Fraction f1, Fraction f2) {
        Fraction res = new Fraction();
        res.setNum(f1.getNum() * f2.getNum());
        res.setDen(f1.getDen() * f2.getDen());
        res.simplify();
        return res;
    }
}
