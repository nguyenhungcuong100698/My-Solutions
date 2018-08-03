/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj_week1_assignment2;

/**
 *
 * @author TOSHIBA
 */
public class SquareSum {
    private int num1;
    private int num2;

    public SquareSum(int num1, int num2) {
    this.num1=num1;
    this.num2=num2;
    }
    public long calculateSquareSum(){
        long temp=0;
        for (;num1<=num2;num1++)
            temp+=num1*num1;
        return temp;
    }
    
    
}
