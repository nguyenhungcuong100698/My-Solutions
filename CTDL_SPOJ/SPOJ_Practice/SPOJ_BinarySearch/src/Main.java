
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
        int[] myList = new int[scan.nextInt()];
        int times = scan.nextInt();
        for (int i = 0; i < myList.length; i++) {
            myList[i] = scan.nextInt();
        }
        Arrays.sort(myList);
        for (int i = 0; i < times; i++) {
            int number = scan.nextInt();
            System.out.print(finding2(myList, 0, myList.length - 1, number) + " ");
        }
    }

    static int finding(int[] myList, int left, int right, int number) {
        while (left < right) {
            int middle = (left + right) / 2;
            if (myList[middle] >= number) {
                return finding(myList, left, middle, number);
            } else {
                return finding(myList, middle + 1, right, number);
            }
        }
        if (myList[left] == number) {
            return left;
        }
        return -1;
    }
    static int finding2(int[] myList, int left, int right, int number) {
        while (left+1 < right) {
            int middle = (left + right) / 2;
            if (myList[middle] >= number) {
                right=middle;
            } else {
                left=middle;
            }
        }
        if (myList[left] == number) {
            return left;
        }
        if (myList[right]==number){
        return right;
    }
        return -1;
    }
}
