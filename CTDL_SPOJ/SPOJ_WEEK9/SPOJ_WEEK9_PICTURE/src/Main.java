
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
class Main {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int numOfTestCases = reader.nextInt();
        for (int i = 0; i < numOfTestCases; i++) {
            String[] input = new String[reader.nextInt()];
            reader.nextInt();
            for (int j = 0; j < input.length; j++) {
                input[j] = reader.next();
            }
            int up = 0;
            int down = input.length - 1;
            while (!input[up].contains("*")) {
                up++;
            }
            while (!input[down].contains("*")) {
                down--;
            }
            int left=Integer.MAX_VALUE;
            int right=-1;
            StringBuilder result = new StringBuilder();
            for (int k=up;k<=down;k++){
                int resLeft=input[k].indexOf("*");
                int resRight = input[k].lastIndexOf("*");
                if (resLeft<left&&resLeft!=-1){
                    left=resLeft;
                }
                if (resRight>right){
                    right=resRight;
                }
            }
            for (int k=up;k<=down;k++){
                result.append(input[k].subSequence(left, right+1));
                result.append("\n");
            }
            System.out.println(result);
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
