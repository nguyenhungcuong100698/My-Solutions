
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int number = reader.nextInt();
        String name1st = "";
        String name2nd = "";
        double score1st = -1;
        double score2nd = -1;
        for (int i = 0; i < number; i++) {
            String tempName = reader.next();
            int tempSubject = reader.nextInt();
            double sum = 0;
            for (int j = 0; j < tempSubject; j++) {
                sum += reader.nextInt();
            }
            sum /= tempSubject;
            //System.out.println(sum);
            if (sum > score2nd) {
                if (sum > score1st) {
                    name2nd = name1st;
                    score2nd = score1st;
                    name1st = tempName;
                    score1st = sum;
                } else {
                    name2nd = tempName;
                    score2nd = sum;
                }
            }
        }
        if (number == 1) {
            System.out.println(name1st);
        } else {
            System.out.println(name1st + "\n" + name2nd);
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
