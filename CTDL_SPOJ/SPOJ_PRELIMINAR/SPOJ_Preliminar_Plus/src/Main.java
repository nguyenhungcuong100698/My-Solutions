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
 class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputReader scan = new InputReader(System.in);
        int numStudent = scan.nextInt();
        int numSub = scan.nextInt();
        HashMap<String, student> myMap = new HashMap<>();
        HashMap<String,Integer> res = new HashMap<>();
        res.put("A",3);
        res.put("B",5);
        res.put("C",8);
        res.put("D",10);
        res.put("E",12);
        res.put("F",15);
        for (int i = 0; i < numStudent; i++) {
            long a = scan.nextLong();
            String b = scan.next();
            myMap.put(b, new student(a, b));
        }
        for (int i=0;i<numSub;i++){
            scan.nextInt();
            String name=scan.next();
            String a = scan.next();
            myMap.get(name).add(res.get(a));
        }
        ArrayList<student> myList = new  ArrayList<>(myMap.values());
        myList.sort((a,b)->{
            if (a.total == b.total) {
                return a.id.compareTo(b.id);
            }
            return b.total - a.total;
        });
        for (student i:myList){
            System.out.println(i.id+" "+i.name+" "+i.total);
        }
    }

    static class student  {

        Long id;
        String name;
        int total = 0;
        public void add(int n){
            this.total+=n;
        }
        public student(long id, String name) {
            this.id = id;
            this.name = name;
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
