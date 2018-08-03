/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package spoj_week2_assignment1;

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
        String firstLetter = reader.next();
        String secondLetter = reader.next();
        int theLength;
        if (firstLetter.length() >= secondLetter.length()) {
            theLength = secondLetter.length();
        } else {
            theLength = firstLetter.length();
        }
        for (int i = firstLetter.length()-theLength,j=theLength; i <= firstLetter.length()&&j>=0; i++,j--) {
            String firstTemp = firstLetter.substring(i);
            //System.out.println(firstTemp);
            String secondTemp = secondLetter.substring(0,j);
            //System.out.println(secondTemp);
            //break;
            if (firstTemp.equals(secondTemp)) {
                firstLetter = firstLetter.substring(0,i);
                break;
            }
        }
        System.out.println(firstLetter.length() + secondLetter.length());

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
