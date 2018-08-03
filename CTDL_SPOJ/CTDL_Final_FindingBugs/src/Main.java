
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
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

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InputReader scan = new InputReader(System.in);
        int numMachine = scan.nextInt();
        int step = scan.nextInt();
        double bugRate = scan.nextDouble();
        HashMap<Integer,Machine> hm = new HashMap<>();
        
        for (int i=0;i<numMachine;i++){
            int id = scan.nextInt();
            boolean isGood = (scan.next().equals("G"));
            Machine machine = hm.get(id);
            if (machine == null){
                machine = new Machine(id);
                if (step == 1){
                    if (!isGood){
                        machine.isFixed++;
                    }
                        
                } else {
                    machine.check.add(isGood);
                }        
                
                hm.put(id,machine);
            } else {
                machine.check.add(isGood);
                
                if (machine.check.size() == step){
                    if (machine.calculate() > bugRate) {
                        machine.isFixed++;
                        machine.check.clear();
                    }
                }
            }
        }
        
        ArrayList<Machine> list = new ArrayList<>(hm.values());
        Collections.sort(list);
        for (int i=0;i<list.size();i++){
            Machine machine = list.get(i);
            if (machine.isFixed != 0){
                System.out.print(machine.toString());
            }
        }
    }
    static class Machine implements Comparable<Machine>{
        Integer id;
        Integer isFixed = 0;
        ArrayList<Boolean> check = new ArrayList<>();

        public Machine(int id) {
            this.id = id;
        }
        
        public double calculate() {
            int count =0;
            for (int i=0;i<check.size();i++){
                if (!check.get(i)){
                    count++;
                }
            }
            
            return (double)count/check.size();
        }

        @Override
        public int compareTo(Machine t) {
            int res = this.isFixed.compareTo(t.isFixed);
            if (res==0){
                res = this.id.compareTo(t.id);
            }
            return res;
        }

        @Override
        public String toString() {
            return id + " ";
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
