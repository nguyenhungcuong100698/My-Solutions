

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

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
        int numTrade = scan.nextInt();
        TreeMap<Integer, Long[]> myProduct = new TreeMap<>();
        for (int i = 0; i < numTrade; i++) {
            String res = scan.next();
            int code = scan.nextInt();
            long quantity = scan.nextLong();
            long price = scan.nextLong();
            boolean flag = myProduct.containsKey(code);
            if (res.equals("+")) {
                if (!flag) {
                    myProduct.put(code, new Long[]{quantity, price * quantity, 0l});
                } else {
                    Long[] temp = myProduct.get(code);
                    temp[0] += quantity;
                    temp[1] += (quantity * price);
                }
            } else {
                Long[] temp = myProduct.get(code);
                if (flag && temp[0] >= quantity) {
                    temp[0] -= quantity;
                    temp[2] += (quantity * price);
                }
            }
        }

        myProduct.entrySet().forEach((entry) -> {
            Long[] temp = (Long[]) entry.getValue();
            System.out.println(entry.getKey() + " " + temp[1] + " " + temp[2]);
        });
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
