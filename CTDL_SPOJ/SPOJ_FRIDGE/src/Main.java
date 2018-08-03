
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author LENOVO
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int top = (int) Math.ceil(Math.cbrt(num));
        int a = top;
        int b = top;
        ArrayList<Integer> out = check(a, b, num, top);
        out.sort((x, y) -> y - x);
        System.out.println(out.get(0) + " " + out.get(1) + " " + out.get(2));
    }

    static ArrayList<Integer> check(int a, int b, int num, int top) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (; a >= 1; a--) {
            for (b = a; b >= 1; b--) {
                if (num % (a * b) == 0) {
                    //System.out.println(num + " " + a + " " + b);
                    arr.add((num / (a * b)));
                    arr.add(a);
                    arr.add(b);
                    return arr;
                }
            }
        }
        return arr;
    }

}
