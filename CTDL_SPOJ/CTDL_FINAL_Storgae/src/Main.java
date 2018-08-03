
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
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
        int numTrade = scan.nextInt();
        HashMap<Integer, LinkedList<product>> list = new HashMap<>();
        LinkedList<product> resList;
        LinkedList<product> toDelete;
        String a;
        int id;
        long quantity;
        long price;
        int time;
        for (int i = 0; i < numTrade; i++) {
            a = scan.next();
            id = scan.nextInt();
            quantity = scan.nextLong();
            price = scan.nextLong();
            time = scan.nextInt();
            if (a.equals("+")) {
                if (list.containsKey(id)) {
                    list.get(id).add(new product(id, quantity, price, time));
                } else {
                    resList = new LinkedList<>();
                    resList.add(new product(id, quantity, price, time));
                    list.put(id, resList);
                }
            } else {
                resList = list.get(id);
                if (resList == null) {
                    continue;
                }
                toDelete = new LinkedList<>();
                for (product store : resList) {
                    if (store.quantity > quantity) {
                        store.quantity -= quantity;
                        quantity = 0;
                        break;
                    }
                    if (store.quantity == quantity) {
                        resList.remove(store);
                        quantity = 0;
                        break;
                    }
                    quantity -= store.quantity;
                    toDelete.add(store);
                }
                if (quantity == 0) {
                    if (!toDelete.isEmpty()) {
                        for (product k : toDelete) {
                            resList.remove(k);
                        }
                    }
                }
                if (resList.isEmpty()) {
                    list.remove(id);
                }
            }
        }
        ArrayList<product> result = new ArrayList<>();
        Set set = list.entrySet();
        Iterator i = set.iterator();
        Map.Entry me;
        product res;
        product temp;
        while (i.hasNext()) {
            me = (Map.Entry) i.next();
            resList = (LinkedList) me.getValue();
            res = resList.get(0);
            res.price *= res.quantity;
            for (int k = 1; k < resList.size(); k++) {
                temp = resList.get(k);
                res.quantity += temp.quantity;
                res.price += (temp.quantity * temp.price);
            }
            result.add(res);
        }
        result.sort((x, y) -> {
            return x.id - y.id;
        });
        for (product k : result) {
            System.out.println(k.id + " " + k.quantity + " " + k.price / k.quantity + " " + k.time);
        }
    }

    static class product {

        int id;
        long quantity;
        long price;
        int time;

        public product(int id, long quantity, long price, int time) {
            this.id = id;
            this.quantity = quantity;
            this.price = price;
            this.time = time;
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
