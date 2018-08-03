
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputReader scan = new InputReader(System.in);
        ArrayList<computer> list = new ArrayList<>();
        int n = scan.nextInt();
        while (n-- > 0) {
            int a = scan.nextInt();
            int b = scan.nextInt();
            list.add(new computer(a, b));
        }
        if (list.size()<2){
            System.out.println("Poor Beo");
            return;
        }
        list.sort((x,y)->{
            return x.price-y.price;
        });
        int i=0;
        for (;i<list.size()-1;i++){
            if (list.get(i).power>list.get(i+1).power){
                System.out.println("Happy Beo");
                return;
            }
        }
        if (i==list.size()-1){
            System.out.println("Poor Beo");
        }
    }
    
    static class computer{
        int price;
        int power;

        public computer(int price, int power) {
            this.price = price;
            this.power = power;
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
