/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.Scanner;
/**
 *
 * @author TOSHIBA
 */
/* Assignment 1 on SPOJ week 1 
Teacher : Ngoc
Detail: Input a string with a number of time that every character of the string will be duplicated
        Input sample: 2
                      1 3 abc
                      2 4 @#$
        Output sample: 1 aaabbbccc
                       2 @@@@####$$$$
*/
public class myMain {
 public static void main(String[] args)
 {
     Scanner scan = new Scanner(System.in);
     int numOfTest = scan.nextInt();
     StringBuilder[] myString = new StringBuilder[numOfTest]; //Using StringBuilder to add
     MultiplyString myStr; //create object mtStr             //chars to string
     for (int i=0;i<numOfTest;i++){
         scan.nextInt(); //Skip the ordinary numbers
         myStr = new MultiplyString(scan.nextInt(),scan.next());//take in number of duplication time and the string
         myString[i] = myStr.appendString(); //Save the duplicated string
     }
     for (int i=0;i<numOfTest;i++){
         System.out.println((i+1)+" "+myString[i]); //Output
     }
 }
}
