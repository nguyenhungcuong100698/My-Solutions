import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

 public class Main1 {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int n = reader.nextInt();
        int p = reader.nextInt();
        int m = reader.nextInt();
        HashMap<Integer, student> Students = new HashMap<>();
        int i = 0;
        int[] arr1 = new int[n];
        int[] arr2 = new int[p];
        student temp;
        for (; i < n; i++) {
            arr1[i] = reader.nextInt();
        }
        for (i = 0; i < p; i++) {
            arr2[i] = reader.nextInt();
        }
        for (i = 0; i < n; i++) {
            temp = new student(arr1[i], p);
            for (int h = 0; h < p; h++) {
                temp.scores.put(arr2[h], 0);
            }
            Students.put(arr1[i], temp);
        }
        for (int j = 0; j < m; j++) {
            int a = reader.nextInt();
            int b = reader.nextInt();
            int c = reader.nextInt();
            if (Students.get(a).scores.get(b) < c) {
                Students.get(a).scores.put(b, c);
            }
        }
        ArrayList<student> stuList = new ArrayList<>(Students.values());
        stuList.sort((a,b)->{
            return a.studentID-b.studentID;
        });

        StringBuilder sb =new StringBuilder();
                 
        for(i=0;i<stuList.size();i++)
        {
           sb.append(stuList.get(i).studentID).append(" ").append(stuList.get(i).caculateScore());
           sb.append("\n");
        }
        System.out.println(sb);
    }

    public static class student {

        private int studentID;
        private int nHomework;
        public HashMap<Integer, Integer> scores = new HashMap<>();

        public student(int studentID, int nHomework) {
            this.studentID = studentID;
            this.nHomework = nHomework;

        }

        public int getStudentID() {
            return studentID;
        }

        public void setStudentID(int studentID) {
            this.studentID = studentID;
        }

        public int getnHomework() {
            return nHomework;
        }

        public void setnHomework(int nHomework) {
            this.nHomework = nHomework;
        }

        public HashMap<Integer, Integer> getScores() {
            return scores;
        }

        public void setScores(HashMap<Integer, Integer> scores) {
            this.scores = scores;
        }

        private int caculateScore() {
            int score = 0;
            score = scores.values().stream().map((val) -> val).reduce(score, Integer::sum);
            return score / this.nHomework;
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
