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
/*Assignment 6 on SPOJ week 1 
Teacher : Ngoc
Detail: A woman(Hang) wants to borrow some money from her friend(Tuan), but he does not want to
So they play a little game related to a specaial desk of cards, the winner decides whether to lend money or not
*/
class Main_2 {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int numOfGames = reader.nextInt();
        int numWin_T = 0;
        int numWin_H = 0;
        for (int i = 0; i < numOfGames; i++) {
            String str = reader.next();//Input the Desk // Input sample: THHTHHTHTT
            int numOfChar_T = 0;        
            int numOfChar_H = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == 'T') {
                    numOfChar_T++;
                } else {
                    numOfChar_H++;
                }
            }
            if (numOfChar_T > numOfChar_H) {
                numWin_T++;
            }
            if (numOfChar_H > numOfChar_T) {
                numWin_H++;
            }
        }
        System.out.println(numWin_H + " " + numWin_T);

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
