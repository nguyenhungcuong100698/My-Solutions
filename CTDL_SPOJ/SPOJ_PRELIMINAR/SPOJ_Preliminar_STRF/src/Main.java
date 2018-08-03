
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
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

        int number = scan.nextInt();
        PriorityQueue<task> processing = new PriorityQueue<>();
        PriorityQueue<task> waiting = new PriorityQueue<>();
        for (int i = 0; i < number; i++) {
            int time = scan.nextInt();
            int duaration = scan.nextInt();
            waiting.add(new task(time, duaration));
        }
        int time = 0;
        int maxTime =0;
        while (!waiting.isEmpty()) {
            if (processing.isEmpty()) {
                task res = waiting.poll();
                processing.add(res);
                if (waiting.isEmpty()) {
                    time = res.time + res.duration - 1;
                } else {
                    time = res.time;
                }
            } else {
                task a = waiting.peek();
                task b = processing.peek();
                if (a.time == b.time) {
                    maxTime+=a.time+a.duration-1;
                    processing.add(new task(maxTime, a.duration));
                    waiting.remove();
                } else if (b.time + b.duration > a.time && a.duration < b.duration + b.time - a.time) {
                    time = a.time;
                    b.duration-=a.time-b.time;
                    b.time = time;
                    processing.add(a);
                    waiting.remove();
                } else {
                    time = b.time + b.duration - 1;
                    processing.remove();
                }
            }
        }
        while (!processing.isEmpty()) {
            task a = processing.poll();
            time = a.time + a.duration-1;
        }
        System.out.println(time);
    }

    static class task implements Comparable<task> {

        int time;
        int duration;

        public task(int time, int duration) {
            this.time = time;
            this.duration = duration;
        }

        @Override
        public int compareTo(task t) {
            if (this.time == t.time) {
                return this.duration - t.duration;
            }
            return this.time - t.time;
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
