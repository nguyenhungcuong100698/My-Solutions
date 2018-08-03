
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
        int number = scan.nextInt();
        for (int k=0;k<number;k++){
            int n = scan.nextInt();
            int m = scan.nextInt();
            int max=-1;int count=0;
            for (int i=0;i<n;i++){
                for (int j=0;j<m;j++){
                    int res = scan.nextInt();
                    if (res>=max){
                        if (res==max){
                            count++;
                        } else {
                            max=res;
                            count=1;
                        }
                    } 
                }
            }
            System.out.println(max+" "+count );
        }

    }
    
}
