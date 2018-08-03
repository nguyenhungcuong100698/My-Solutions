
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int number = reader.nextInt();
        Students myStudents = new Students(number);
        for (int i = 0; i < number; i++) {
            String choice = reader.next();
            if (choice.equalsIgnoreCase("Add")) {
                long id = reader.nextLong();
                String name = reader.next();
                myStudents.add(id, name);
                continue;
            }
            if (choice.equalsIgnoreCase("Count")) {
                System.out.println(myStudents.showCount());
                continue;
            }
            if (choice.equalsIgnoreCase("GetAt")) {
                int index = reader.nextInt();
                System.out.println(myStudents.getAt(index));
                continue;
            }
            if (choice.equalsIgnoreCase("RemoveId")) {
                long id = reader.nextLong();
                myStudents.removeId(id);
            }
        }
    }

    public static class Students {

        private Student[] myStudent;
        private int count = 0;

        public Students(int number) {
            myStudent = new Student[number];
        }

        public int findByID(long id) {
            for (int i = 0; i < count; i++) {
                if (myStudent[i].ID == id) {
                    return i;
                }
            }
            return -1;
        }

        public String getAt(int index) {
            if (index < count) {
                return (myStudent[index].ID + " " + myStudent[index].name);
            }
            return "";
        }

        public void removeId(long id) {
            int index = this.findByID(id);
            if (index != -1) {
                Student[] tempStu = new Student[myStudent.length];
                for (int i = 0; i < index; i++) {
                    tempStu[i] = myStudent[i];
                }
                for (int i = index; i < count; i++) {
                    tempStu[i] = myStudent[i + 1];
                }
                myStudent = tempStu;
                count--;
            }
        }

        public void add(long id, String name) {
            if (findByID(id) == -1) {
                myStudent[count++] = new Student(id, name);
            }
        }
        public int showCount(){
            return count;
        }

    }

    public static class Student {

        public long ID;
        public String name;

        public Student(long ID, String name) {
            this.ID = ID;
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
