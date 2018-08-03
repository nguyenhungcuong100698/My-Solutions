/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj_week1_assignment2;

import java.util.Scanner;

/**
 *
 * @author TOSHIBA
 */
/* Assignment 2 on SPOJ week 1 
Teacher : Ngoc
Detail: Calculates the iterated sum of square numbers from a to b
        Input sample: 1 4
        Output sample: 30
Hint : 1 to 4 means 1*1 + 2*2 + 3*3 + 4*4 = 30
*/
public class SPOJ_WEEK1_Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SquareSum squareSum = new SquareSum(sc.nextInt(), sc.nextInt());
        System.out.println(squareSum.calculateSquareSum());
    }
    
}
