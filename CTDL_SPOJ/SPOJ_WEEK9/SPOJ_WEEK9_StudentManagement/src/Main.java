
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
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

    static int numStudent;
    static int numAssignment;
    static int numSubmission;

    public static void main(String[] args) {
        InputReader scan = new InputReader(System.in);
        numStudent = scan.nextInt();
        numAssignment = scan.nextInt();
        numSubmission = scan.nextInt();
        HashMap<Integer, student> students = new HashMap<>();
        int[] res = new int[numStudent];
        for (int i = 0; i < numStudent; i++) {
            res[i] = scan.nextInt();
        }
        int[] res2 = new int[numAssignment];
        for (int i = 0; i < numAssignment; i++) {
            res2[i] = scan.nextInt();
        }
        for (int i = 0; i < numStudent; i++) {
            students.put(res[i], new student(res[i]));
        }
        for (int i = 0; i < numSubmission; i++) {
            int id = scan.nextInt();
            int assignId = scan.nextInt();
            int point = scan.nextInt();
            students.get(id).submit(assignId, point);
        }
        ArrayList<student> myStudent = new ArrayList<>(students.values());
        myStudent.sort((a, b) -> {
            return a.id - b.id;
        });
        for (student i : myStudent) {
            System.out.println(i.id + " " + i.average());
        }
    }

    static class student {

        int id;
        HashMap<Integer, Integer> grade= new HashMap<>();

        public student(int id) {
            this.id = id;
        }
        public void submit(int assignID, int point){
            if (!grade.containsKey(assignID)||grade.get(assignID)<point){
                grade.put(assignID, point);
            }
        }
        public int average() {
            long res = 0;
            ArrayList<Integer> a = new ArrayList<>(grade.values());
            for (Integer i : a) {
                res += i;
            }
            return (int)(res / numAssignment);
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
