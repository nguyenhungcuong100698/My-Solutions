
import java.util.HashMap;
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
        int number = scan.nextInt();
        HashMap<Integer,Integer> myHM = new HashMap<>(number);
        int commands = scan.nextInt();
        for (int i=0;i<number;i++){
            int key=scan.nextInt();
            int value=scan.nextInt();
            myHM.put(key, value);
        }
        for (int i=0;i<commands;i++){
            int a = scan.nextInt();
            System.out.println(myHM.get(a));
        }
    }
   
}
