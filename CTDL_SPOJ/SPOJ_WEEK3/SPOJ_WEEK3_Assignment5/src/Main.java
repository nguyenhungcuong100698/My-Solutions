
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
        int[] edges = new int[scan.nextInt()];
        int count = 0;
        for (int i = 0; i < edges.length; i++) {
            edges[i] = scan.nextInt();
        }
        for (int i = 0; i < edges.length; i++) {
            for (int j = i + 1; j < edges.length; j++) {
                for (int k = j + 1; k < edges.length; k++) {
                    if (edges[i] + edges[j] > edges[k] && edges[i] + edges[k] > edges[j] && edges[j] + edges[k] > edges[i]) {
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }

}
