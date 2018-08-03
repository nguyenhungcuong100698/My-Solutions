
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {
        InputReader scan = new InputReader(System.in);
        PriorityQueue<people> list = new PriorityQueue<>();
        int n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(new people(i + 1, 0));
        }
        int work = scan.nextInt();
        ArrayList<Long> workList = new ArrayList<>(work);
        for (int i = 0; i < work; i++) {
            workList.add(scan.nextLong());
        }
        workList.sort((n1, n2) -> {
            return n2.compareTo(n1);
        });
        for (int i = 0; i < work; i++) {
            people res = list.poll();
            res.time += workList.get(i);
            list.add(res);
        }
        ArrayList<people> result = new ArrayList<>();
        for (int i=0;i<n;i++){
            result.add(list.poll());
        }
        result.sort((n1, n2) -> {
            return n1.id-n2.id;
        });
        for (int i = 0; i < n; i++) {
            System.out.print(result.get(i).time+" ");
        }

    }
 static class people implements Comparable<people> {

        int id;
        int time;

        public people(int id, int time) {
            this.id = id;
            this.time = time;
        }

        @Override
        public int compareTo(people t) {
            int res = this.time - t.time;
            if (res == 0) {
                res = this.id - t.id;
            }
            return res;
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
