
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
        int numStd = scan.nextInt();
        int[] stdList = new int[numStd];
        if (numStd!=1){
        for (int i = 0; i < stdList.length; i++) {
            stdList[i] = scan.nextInt();
        }
        Arrays.sort(stdList);
        int j = stdList.length - 1;
        int count = 0;
        while (j != 0) {
            count = 0;
            for (; j > 0; j--) {
                if (stdList[j] == stdList[j - 1]) {
                    count++;
                } else {
                    count++;
                    break;
                }
            }

            if (j == 0) {
                if (stdList[j] == stdList[j + 1]) {
                    count++;
                }
            } else {
                System.out.println(stdList[j--] + " " + count);
            }

        }
        System.out.println(stdList[j]+" "+count);
        } else System.out.println(scan.nextInt()+" 1");
    }

}
