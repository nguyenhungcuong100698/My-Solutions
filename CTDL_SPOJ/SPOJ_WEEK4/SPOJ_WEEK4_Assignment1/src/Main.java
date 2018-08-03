
import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

class Main {

    public static void main(String[] args) {
        InputReader reader = new InputReader(System.in);
        int number = reader.nextInt();
        ArrayList<Name> nameList = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            String tempName = "";
            try {
                tempName = reader.nextLine();
            } catch (IOException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            Name myName = new Name(tempName);
            nameList.add(myName);

        }
        nameList.sort((a, b) -> {
            if (a.lastName.compareTo(b.lastName) == 0)
            {
                if (a.firstName.compareTo(b.firstName) == 0)
                {
                    if (a.middleName.compareTo(b.middleName) > 0) {
                        return 1;
                    }
                    if (a.middleName.compareTo(b.middleName) < 0) {
                        return -1;
                    } else return 0;
                }
                if (a.firstName.compareTo(b.firstName) > 0) {
                    return 1;
                }  else return -1;
                
            }
            if (a.lastName.compareTo(b.lastName) > 0) {
                return 1;
            } else return -1; 
        });
        for (Name name : nameList) {
            System.out.println(name.firstName+name.middleName+" "+name.lastName);
        }
    }

    public static class Name {

        public String firstName;
        public String middleName;
        public String lastName;
        public String fullName;

        public Name(String tempName) {
            int firstIndex = tempName.indexOf(" ");
            int lastIndex = tempName.lastIndexOf(" ");
            firstName =tempName.substring(0, firstIndex); 
            middleName = tempName.substring(firstIndex, lastIndex);
            lastName = tempName.substring(lastIndex + 1);
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
