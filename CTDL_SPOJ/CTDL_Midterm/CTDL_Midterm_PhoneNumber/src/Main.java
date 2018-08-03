
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;


public class Main {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int number = reader.nextInt();
        ArrayList<Long> array = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            long phoneNum = reader.nextLong();
            if (phoneNum >= 100000000 && phoneNum < 9999999999l) {
                array.add(phoneNum);
            }
        }
        Collections.sort(array);
        for (int i = 0; i < array.size(); i++) {
            if (i == (array.size() - 1)) {
                System.out.println(array.get(i));
                break;
            }
            if (array.get(i).equals(array.get(i + 1))==false) {
                System.out.println(array.get(i));
            }

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
