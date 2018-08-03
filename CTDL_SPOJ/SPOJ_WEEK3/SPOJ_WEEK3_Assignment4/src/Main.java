
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
        int numLog = scan.nextInt();
        long[] myArray = new long[numLog];
        for (int i=0;i<myArray.length;i++){
            myArray[i]=scan.nextLong();
        }
        long time=0;
        Arrays.sort(myArray);
//        for (int k=0;k<myArray.length;k++){
//            System.out.print(myArray[k]+" ");
//        }
//        System.out.println("");
        int i=0,j=1;
        for (;i<myArray.length-1;i++){
            for (;j<myArray.length;j++){
                if (myArray[j]-myArray[i]<=600000) time+=(j-i);
                else {
                    break;
                }
            }
        }
        System.out.println(time);
    }
    
}
