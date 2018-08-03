
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
        int numTinChi = scan.nextInt();
        ArrayList<student> myStudent = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            int id = scan.nextInt();
            String name = scan.next();
            int numSubject = scan.nextInt();
            int sum = 0;
            int count = 0;
            for (int j = 0; j < numSubject; j++) {
                int subject = scan.nextInt();
                if (subject >= 50) {
                    sum += subject;
                    count++;
                }
            }
            if (count*4 >= numTinChi) {
                sum /= count;
                myStudent.add(new student(id, name, sum));
            }
        }
        myStudent.sort((a, b) -> {
            if (a.AverMark < b.AverMark) {
                return 1;
            } else if (a.AverMark > b.AverMark) {
                return -1;
            } else if (a.id > b.id) {
                return 1;
            } else if (a.id < b.id) {
                return -1;
            } else {
                return 0;
            }
        });
        for (int i = 0; i < myStudent.size(); i++) {
            student res = myStudent.get(i);
            System.out.println(res.id + " " + res.name + " " + res.AverMark);
        }

    }

    static class student {

        private int id;
        private String name;
        private int AverMark = 0;

        public student(int id, String name, int AverMark) {
            this.name = name;
            this.id = id;
            this.AverMark = AverMark;
        }

    }

}
