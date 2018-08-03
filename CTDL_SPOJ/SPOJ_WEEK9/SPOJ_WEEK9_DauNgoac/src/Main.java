
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        InputReader scan = new InputReader(System.in);
        Stack myStack = new Stack();
        StringBuilder result = new StringBuilder();
        while (true) {
            myStack.clear();
            String input = scan.nextLine();
            //System.out.println(input);
            boolean check = true;
            if (!input.equals(".")) {
                for (int i = 0; i < input.length(); i++) {
                    char n = input.charAt(i);
                    if (n == '(' || n == '[') {
                        myStack.push(n);
                    } else if (n == ')' || n == ']') {
                        if (myStack.empty()) {
                            check = false;
                        } else if (n == ')') {
                            if ((char) myStack.pop() != '(') {
                                check = false;
                                break;
                            }
                        } else {
                            if ((char) myStack.pop() != '[') {
                                check = false;
                                break;
                            }
                        }

                    }
                }
                if (myStack.empty()) {
                    if (check) {
                        result.append("yes\n");
                    }else{
                        result.append("no\n");
                    }
                } else {
                    result.append("no\n");
                }
            } else {
                break;
            }
        }
        System.out.println(result);
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
