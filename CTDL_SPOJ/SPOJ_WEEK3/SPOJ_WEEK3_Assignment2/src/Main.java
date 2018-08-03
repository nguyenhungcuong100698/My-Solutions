
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
        int numProduct = scan.nextInt();
        int money = scan.nextInt();
        int[] values = new int[numProduct];
        for (int i = 0; i < values.length; i++) {
            values[i] = scan.nextInt();
        }
        int maxValue = 0, minValue = Integer.MAX_VALUE;

        Arrays.sort(values);

        int a, b;
        for (a = values.length - 1; a >= 0; a--) {
            if (values[a] <= money) {
                break;
            }
        }
        for (; a > 0; a--) {
            for (b = a - 1; b >= 0; b--) {
                if (values[a] + values[b] <= money && values[a] + values[b] >= maxValue && values[a] - values[b] < minValue) {
                    maxValue = values[a] + values[b];
                    minValue = values[a] - values[b];
//                    if (values[a]-values[b]<minValue){
//                    maxValue=values[a]+values[b];
//                    minValue=values[a]-values[b];
//                    }
                }
            }
        }
        if (maxValue != 0 && minValue != Integer.MAX_VALUE) {
            System.out.println(maxValue + " " + minValue);
        } else {
            System.out.println("-1 -1");
        }
    }
}
