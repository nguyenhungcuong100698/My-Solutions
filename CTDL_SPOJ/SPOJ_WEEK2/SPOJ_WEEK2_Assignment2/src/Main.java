/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 * @author TOSHIBA
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int numLaterns = reader.nextInt();
        long roadLength = reader.nextLong();
        double maxDistance = 0.0;
        long temp = reader.nextLong();
        long disStart = temp;
        for (int i = 1; i < numLaterns; i++) {
            long laternLocation = reader.nextLong();
            if (laternLocation - temp > maxDistance) {
                maxDistance = laternLocation - temp;
            }
            temp = laternLocation;
        }
        long disLast = roadLength-temp;
        maxDistance /= 2.0;
        long tam=disStart;
        if (disLast>disStart) tam=disLast;
        if (maxDistance>tam) System.out.println(maxDistance);
        else System.out.println(tam);
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