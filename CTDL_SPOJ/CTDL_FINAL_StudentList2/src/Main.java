
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
        int n = scan.nextInt();
        int k = scan.nextInt();
        ArrayList<student> myList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            long mssv = scan.nextLong();
            String name = scan.next();
            int numSub = scan.nextInt();
            ArrayList<Integer> res = new ArrayList();
            for (int j = 0; j < numSub; j++) {
                int grade = scan.nextInt();
                if (grade >= 50) {
                    res.add(grade);
                }
            }
            myList.add(new student(i, mssv, name, res));
        }
        myList.sort((a, b) -> {
           int res = b.sum.compareTo(a.sum);
           if (res==0){
               return b.tinchi-a.tinchi;
           }
           return res;
        });

        if (k < n) {
            student pivot = myList.get(k);
            for (int i = 0; i < k; i++) {
                student res = myList.get(i);
                if (res.sum.equals(pivot.sum)&&res.tinchi.equals(pivot.tinchi)) {
                    break;
                }
                int sum = res.sum.intValue();
                if (res.sum - res.sum.intValue() >= 0.5) {
                    sum++;
                }
                System.out.println(res.mssv + " " + res.name + " " + sum + " " + res.tinchi);
            }
        } else {
            for (int i = 0; i < k; i++) {
                student res = myList.get(i);
                int sum = res.sum.intValue();
                if (res.sum - res.sum.intValue() >= 0.5) {
                    sum++;
                }
                System.out.println(res.mssv + " " + res.name + " " + sum + " " + res.tinchi);
            }
        }
    }

    static class student {

        int id;
        long mssv;
        String name;
        ArrayList<Integer> subject;
        Double sum;
        Integer tinchi;

        public student(int id, long mssv, String name, ArrayList<Integer> subject) {
            this.id = id;
            this.mssv = mssv;
            this.name = name;
            this.subject = subject;
            double res = 0;
            for (Integer i : subject) {
                res += i;
            }
            if (subject.isEmpty()) {
                this.sum = 0.0;
            } else {
                this.sum = res / subject.size();
            }
            this.tinchi = subject.size() * 4;
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
