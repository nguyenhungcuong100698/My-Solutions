
import java.util.ArrayList;
import java.util.Collections;
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
public class Main2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int numProduct = scan.nextInt();
        int money = scan.nextInt();
        ArrayList values = new ArrayList();
        for (int i = 0; i < numProduct; i++) {
            int temp = scan.nextInt();
            if (temp <= money) {
                values.add(temp);
            }
        }
        if (values.isEmpty() == false) {
            int maxValue = 0, minValue = Integer.MAX_VALUE;

            Collections.sort(values);
            int a = values.size() - 1, b;
            for (; (int) values.get(a) <= money && (int) values.get(a) >= (money / 2) && a > 0; a--) {
                for (b = a - 1; b >= 0; b--) {
                    int tempMax = (int) values.get(a) + (int) values.get(b);
                    int tempMin = (int) values.get(a) - (int) values.get(b);
                    if (tempMax <= money && tempMax >= maxValue && tempMin < minValue) {
                        maxValue = tempMax;
                        minValue = tempMin;
                        break;
                    }
                }
            }
            if (a != 0) {
                if ((int) values.get(a) < money / 2) {
                    int tempMax = (int) values.get(a) + (int) values.get(a - 1);
                    int tempMin = (int) values.get(a) - (int) values.get(a - 1);
                    if (tempMax <= money && tempMax >= maxValue && tempMin < minValue) {
                        maxValue = tempMax;
                        minValue = tempMin;
                    }
                }
            }
            if (maxValue != 0 && minValue != Integer.MAX_VALUE) {
                System.out.println(maxValue + " " + minValue);
            } else {
                System.out.println("-1 -1");
            }
        } else {
            System.out.println("-1 -1");
        }
    }
}
