
import java.util.ArrayList;
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
        student[] myStudent = new student[number];
        for (int i = 0; i < number; i++) {
            String name = scan.next();
            int numSubject = scan.nextInt();
            ArrayList<Integer> res = new ArrayList();
            int sum=0;
            int count=0;
            for (int j = 0; j < numSubject; j++) {
                int subject = scan.nextInt();
                if (subject >= 50) {
                    res.add(subject);
                    sum+=subject;
                    count++;
                }
            }
            if (count!=0){
                sum/=count;
            }
            myStudent[i] = new student(name, res,sum);
        }
        for (int i=0;i<number;i++){
            System.out.print(myStudent[i].name+" ");
            for (int j:myStudent[i].marks){
                System.out.print(j+" ");
            }
            System.out.println(myStudent[i].AverMark);
        }

    }

    static class student {

        private String name;
        private int AverMark = 0;
        private ArrayList<Integer> marks;

        public student(String name, ArrayList marks, int AverMark) {
            this.name = name;
            this.marks = marks;
            this.AverMark = AverMark;
        }

    }

}
