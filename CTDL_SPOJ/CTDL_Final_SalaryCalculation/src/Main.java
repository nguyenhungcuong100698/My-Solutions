
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

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
        InputReader scan = new InputReader(System.in);

        int numEmployees = scan.nextInt();
        int minWorkDays = scan.nextInt();
        int workDays = scan.nextInt();

        ArrayList<employee> list = new ArrayList<>();
        for (int i = 0; i < numEmployees; i++) {
            int id = scan.nextInt();
            String name = scan.next();
            int payRate = scan.nextInt();
            double days = 0.0;
            for (int j = 0; j < workDays; j++) {
                int time = scan.nextInt();
                if (time >= 4) {
                    if (time < 8) {
                        days += 0.5;
                    } else {
                        days++;
                    }
                }
            }

            list.add(new employee(id, name, payRate, days, minWorkDays));

        }

        Collections.sort(list);
        for (int i = 0; i < numEmployees; i++) {
            System.out.println(list.get(i).toString());
        }

    }

    static class employee implements Comparable<employee> {

        Integer id;
        String name;
        int payRate;
        double days;
        int salary;

        public employee(Integer id, String name, int payRate, double days, int minWorkDays) {
            this.id = id;
            this.name = name;
            this.payRate = payRate;
            this.days = days;
            this.salary = payRate;

            if (minWorkDays > 0) {
                this.salary = (int) Math.ceil((Math.min(1, (days / minWorkDays)) * payRate) - 0.5);
            }

        }

        @Override
        public int compareTo(employee t) {
            int res = this.name.compareTo(t.name);
            if (res == 0) {
                res = this.id.compareTo(t.id);
            }
            return res;
        }

        @Override
        public String toString() {
            return id + " " + name + " " + salary;
        }
    }

    static class InputReader {

        StringTokenizer tokenizer;
        BufferedReader reader;
        String token;
        String temp;

        public InputReader(InputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public InputReader(FileInputStream stream) {
            tokenizer = null;
            reader = new BufferedReader(new InputStreamReader(stream));
        }

        public String nextLine() throws IOException {
            return reader.readLine();
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    if (temp != null) {
                        tokenizer = new StringTokenizer(temp);
                        temp = null;
                    } else {
                        tokenizer = new StringTokenizer(reader.readLine());
                    }

                } catch (IOException e) {
                }
            }
            return tokenizer.nextToken();
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}
