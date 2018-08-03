
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
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

        for (int i = 0; i < myStaff.length; i++) {
            int id = reader.nextInt();
            int sell = reader.nextInt();
            myStaff[i] = new staff(id, sell);
        }
        merge(myStaff, 0, number - 1);

        for (staff myStaff1 : myStaff) {
            System.out.println(myStaff1.id + " " + myStaff1.sell);
        }
    }

    static void merge(staff[] myStaff, int left, int right) {
        int middle;
        if (right > left) {
            middle = (left + right) / 2;
            merge(myStaff, left, middle);
            merge(myStaff, middle + 1, right);
            mergeSort(myStaff, left, middle, right);
        }
    }

    static void mergeSort(staff[] myStaff, int left, int middle, int right) {
        int i = left;
        int j = middle + 1;
        staff[] newStaff = new staff[right - left + 1];
        for (int k = 0; k < newStaff.length; k++) {
            if (myStaff[i].sell <= myStaff[j].sell) {
                newStaff[k] = myStaff[i];
                i++;
            } else {
                newStaff[k] = myStaff[j];
                j++;
            }
            if (i == middle + 1) {
                while (j <= right) {
                    k++;
                    newStaff[k] = myStaff[j];
                    j++;
                }
                break;
            }

            if (j == right + 1) {

                while (i <= middle) {
                    k++;
                    newStaff[k] = myStaff[i];
                    i++;
                }
                break;
            }
        }
        for (int k = 0; k < newStaff.length; k++) {
            myStaff[left + k] = newStaff[k];
        }
    }

    static class staff {

        public int id;
        public int sell;

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
