
import java.util.Scanner;

class LinkedList<T extends Number> {

    static private class LinkedNode<U extends Number> {

        U number;
        LinkedNode<U> next;

        public LinkedNode(U number) {
            this.number = number;
        }
    }

    LinkedNode<T> head = null;
    LinkedNode<T> tail = null;

    private int compare(T n1, T n2) {
        long l1 = n1.longValue();
        long l2 = n2.longValue();
        if (l1 != l2) {
            return (l1 < l2 ? -1 : 1);
        }
        return Double.compare(n1.doubleValue(), n2.doubleValue());
    }

    public int size() {
        LinkedNode res = head;
        int a = 0;
        while (res != null) {
            res = res.next;
            a++;
        }
        return a;
    }

    public void add(T number) {
        LinkedNode<T> newNode = new LinkedNode<>(number);
        if (head==null){
            head=newNode;
            tail=newNode;
        }else{
            LinkedNode res =tail;
            res.next=newNode;
            tail=newNode;
            newNode.next=null;
        }
        
    }

    /**
     * @return -1 if number is not in list
     */
    public int firstIndexOf(T number) {

        LinkedNode res = head;
        int index = 0;
        while (res != null) {
            if (res.number.equals(number)) {
                return index;
            }
            res = res.next;
            index++;
        }
        return -1;
    }

    /**
     * @return -1 if number is not in list
     */
    public int lastIndexOf(T number) {
        LinkedNode res = head;
        int index = -1;
        int count = 0;
        while (res != null) {
            if (res.number.equals(number)) {
                index = count;
            }
            res = res.next;
            count++;
        }
        return index;
    }

    /**
     * Remove first occurence of number
     */
    public void removeFirst(T number) {
        LinkedNode temp = head;
        LinkedNode res = head;
        while (res != null && !res.number.equals(number)) {
            temp = res;
            res = res.next;
        }
        if (res != null) {
            if (res == head) {
                head = head.next;
            } else if (res.next != null) {
                temp.next = res.next;
            } else {
                temp.next = null;
            }
        }
    }

    public void removeAt(int index) {
        if (index == 0) {
            head = head.next;
            return;
        }
        LinkedNode res1 = head;
        LinkedNode res2 = head;
        int count = 0;
        while (res1 != null && count != index) {
            res2 = res1;
            res1 = res1.next;
            count++;
        }
        if (res1 != null) {
            if (res1.next != null) {
                res2.next = res1.next;
            } else {
                res2.next = null;
            }
        }

    }

    public void insertAt(int index, T number) {
        LinkedNode newNode = new LinkedNode(number);
        if (index == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        LinkedNode res = head;
        LinkedNode temp = head;
        int count = 0;
        while (res != null && count != index) {
            temp = res;
            res = res.next;
            count++;
        }
        if (res != null) {
            temp.next = newNode;
            newNode.next = res;

        } else if (count == index) {
            temp.next = newNode;
            newNode.next = null;
        }
    }

    /**
     * @return null if index is out of range
     */
    public T getAt(int index) {
        LinkedNode res = head;
        int count = 0;
        while (res != null && count != index) {
            res = res.next;
            count++;
        }
        if (res != null) {
            return (T) res.number;
        }
        return null;
    }

    public double sum() {
        double result = 0.0;
        LinkedNode res = head;
        while (res != null) {
            result += (Integer) res.number;
            res = res.next;
        }
        return result;
    }

    public double average() {
        int count = 0;
        double result = 0.0;
        LinkedNode res = head;
        while (res != null) {
            result += (Integer) res.number;
            res = res.next;
            count++;
        }
        return result / (double) count;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        LinkedList<Integer> linkedList = new LinkedList<>();
        int n = scan.nextInt();
        int m = scan.nextInt();
        for (int i = 0; i < n; i++) {
            int a = scan.nextInt();
            linkedList.add(a);
        }
        for (int i = 0; i < m; i++) {
            String a = scan.next();
            switch (a) {
                case "getAt":
                    int get = scan.nextInt();
                    System.out.println(linkedList.getAt(get));
                    break;
                case "size":
                    System.out.println(linkedList.size());
                    break;
                case "sum":
                    System.out.println(linkedList.sum());
                    break;
                case "average":
                    System.out.println(linkedList.average());
                    break;
                case "firstIndexOf":
                    int first = scan.nextInt();
                    System.out.println(linkedList.firstIndexOf(first));
                    break;
                case "lastIndexOf":
                    int last = scan.nextInt();
                    System.out.println(linkedList.lastIndexOf(last));
                    break;
                case "removeFirst":
                    int num = scan.nextInt();
                    linkedList.removeFirst(num);
                    break;
                case "removeAt":
                    int at = scan.nextInt();
                    linkedList.removeAt(at);
                    break;
                case "insertAt":
                    int ins = scan.nextInt();
                    int number = scan.nextInt();
                    linkedList.insertAt(ins, number);
                    break;
            }
        }
    }
}
