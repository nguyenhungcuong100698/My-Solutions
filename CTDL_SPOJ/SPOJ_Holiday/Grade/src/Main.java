
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * @author LENOVO
 */
class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        InputReader scan = new InputReader();
        int numStu = scan.nextInt();
        int numWork = scan.nextInt();
        int numSub = scan.nextInt();
        HashMap<Integer, student> studentList = new HashMap<>();
        for (int i = 0; i < numStu; i++) {
            int id = scan.nextInt();
            studentList.put(id, new student(id));
        }
        HashSet<Integer> homeworkList = new HashSet<>();
        for (int i = 0; i < numWork; i++) {
            homeworkList.add(scan.nextInt());
        }
        for (int i = 0; i < numSub; i++) {
            int id = scan.nextInt();
            int workId = scan.nextInt();
            int point = scan.nextInt();
            if (homeworkList.contains(workId)) {
                studentList.get(id).calculate(point, workId);
            }
        }
        ArrayList<student> stuList = new ArrayList(studentList.values());
        stuList.forEach((i) -> {
            i.calculateGPA(numWork);
        });
        stuList.sort((a, b) -> {
            int x = b.GPA.compareTo(a.GPA);
            if (x == 0) {
                int y = a.numSubmit.compareTo(b.numSubmit);
                if (y == 0) {
                    return a.id.compareTo(b.id);
                }
                return y;
            }
            return x;
        });
        StringBuilder result = new StringBuilder();
        for (student i : stuList) {
            result.append(i.id + " " + i.GPA + " " + i.numSubmit);
            result.append("\n");
        }
        System.out.println(result);
    }

    static class student {

        Integer id;
        Integer numSubmit = 0;
        HashMap<Integer, Integer> listWork = new HashMap<>();
        int sum = 0;
        Integer GPA = 0;

        public student(int id) {
            this.id = id;
        }

        public void calculateGPA(int numWork) {
            GPA = sum / numWork;
        }

        public void calculate(int point, int workId) {
            Integer res = listWork.get(workId);
            if (res == null) {
                listWork.put(workId, point);
                sum += point;
            } else {
                listWork.put(workId, Math.max(res, point));
                if (res < point) {
                    sum += (point - res);
                }
            }
            numSubmit++;
        }

    }

//    static class InputReader {
//
//        StringTokenizer tokenizer;
//        BufferedReader reader;
//        String token;
//        String temp;
//
//        public InputReader(InputStream stream) {
//            tokenizer = null;
//            reader = new BufferedReader(new InputStreamReader(stream));
//        }
//
//        public InputReader(FileInputStream stream) {
//            tokenizer = null;
//            reader = new BufferedReader(new InputStreamReader(stream));
//        }
//
//        public String nextLine() throws IOException {
//            return reader.readLine();
//        }
//
//        public String next() {
//            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
//                try {
//                    if (temp != null) {
//                        tokenizer = new StringTokenizer(temp);
//                        temp = null;
//                    } else {
//                        tokenizer = new StringTokenizer(reader.readLine());
//                    }
//
//                } catch (IOException e) {
//                }
//            }
//            return tokenizer.nextToken();
//        }
//
//        public double nextDouble() {
//            return Double.parseDouble(next());
//        }
//
//        public int nextInt() {
//            return Integer.parseInt(next());
//        }
//
//        public long nextLong() {
//            return Long.parseLong(next());
//        }
//    }
    static class InputReader {

        InputStream is = System.in;
        byte[] inbuf = new byte[1 << 23];
        int lenbuf = 0, ptrbuf = 0;

        public InputReader() throws IOException {
            lenbuf = is.read(inbuf);
        }

        public int readByte() {

            if (ptrbuf >= lenbuf) {
                return -1;
            }

            return inbuf[ptrbuf++];
        }

        public boolean hasNext() {
            int t = skip();

            if (t == -1) {
                return false;
            }
            ptrbuf--;
            return true;
        }

        public boolean isSpaceChar(int c) {
            return !(c >= 33 && c <= 126);
        }

        public int skip() {
            int b;
            while ((b = readByte()) != -1 && isSpaceChar(b))
				;
            return b;
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public char nextChar() {
            return (char) skip();
        }

        public String next() {
            int b = skip();
            StringBuilder sb = new StringBuilder();
            while (!(isSpaceChar(b))) {
                sb.appendCodePoint(b);
                b = readByte();
            }
            return sb.toString();
        }

        public char[] ns(int n) {
            char[] buf = new char[n];
            int b = skip(), p = 0;
            while (p < n && !(isSpaceChar(b))) {
                buf[p++] = (char) b;
                b = readByte();
            }
            return n == p ? buf : Arrays.copyOf(buf, p);
        }

        public char[][] nm(int n, int m) {
            char[][] map = new char[n][];
            for (int i = 0; i < n; i++) {
                map[i] = ns(m);
            }
            return map;
        }

        public int[] na(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = nextInt();
            }
            return a;
        }

        public int nextInt() {
            int num = 0, b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }

        public long nextLong() {
            long num = 0;
            int b;
            boolean minus = false;
            while ((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'))
				;
            if (b == '-') {
                minus = true;
                b = readByte();
            }

            while (true) {
                if (b >= '0' && b <= '9') {
                    num = num * 10 + (b - '0');
                } else {
                    return minus ? -num : num;
                }
                b = readByte();
            }
        }
    }
}
