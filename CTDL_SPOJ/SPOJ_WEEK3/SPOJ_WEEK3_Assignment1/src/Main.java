
import java.util.ArrayList;
import java.util.Arrays;
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
        int numTest = scan.nextInt();
        for (int i = 0; i < numTest; i++) {
            int[] myArray = new int[scan.nextInt()];
            for (int j = 0; j < myArray.length; j++) {
                myArray[j] = scan.nextInt();
            }
            Arrays.sort(myArray);
            boolean flag = true;
            for (int j = 0; j < myArray.length - 1; j++) {
                if (myArray[j] != myArray[j + 1]) {
                    if (flag)
                    System.out.print(myArray[j] + " ");
                    else 
                    flag = true;
                } else {
                    flag = false;
                }
            }
            if (flag) {
                System.out.print(myArray[myArray.length-1]);
            } 
            System.out.println("");
        }
    }

}
