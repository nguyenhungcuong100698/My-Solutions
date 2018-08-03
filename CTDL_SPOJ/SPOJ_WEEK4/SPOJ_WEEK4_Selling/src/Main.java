
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

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
        InputReader reader = new InputReader(System.in);
        int number = reader.nextInt();
        staff[] myStaff = new staff[number];

        for (int i=0;i<myStaff.length;i++) {
            int id = reader.nextInt();
            int sell = reader.nextInt();
            myStaff[i] = new staff(id,sell);
        }
        for (int i = 1; i < myStaff.length; i++) {
            int index = i;
            for (int j = i - 1; j >= 0; j--) {
                if (myStaff[index].sell < myStaff[j].sell) {
                    staff temp = myStaff[index];
                    myStaff[index] = myStaff[j];
                    myStaff[j] = temp;
                    index--;
                }
            }
        }
        
        for (staff myStaff1 : myStaff) {
            System.out.println(myStaff1.id+" "+myStaff1.sell);
        }
    }

    static class staff {

        private int id;
        private int sell;

        public staff(int id, int sell) {
            this.id = id;
            this.sell = sell;
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
