
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author TOSHIBA
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        String dataType = sc.next();
        switch (dataType) {
            case "int":
                Integer[] myInt = new Integer[number];
                for (int i=0;i<number;i++){
                    myInt[i]=sc.nextInt();
                }
                bubbleSort(myInt);
                for (int i=0;i<number;i++){
                    System.out.print(myInt[i]+" ");
                }
                break;
            case "long":
                Long[] myLong = new Long[number];
                for (int i=0;i<number;i++){
                    myLong[i]=sc.nextLong();
                }
                bubbleSort(myLong);
                for (int i=0;i<number;i++){
                    System.out.print(myLong[i]+" ");
                }
                break;
            case "double":
                Double[] myDouble = new Double[number];
                for (int i=0;i<number;i++){
                    myDouble[i]=sc.nextDouble();
                }
                bubbleSort(myDouble);
                for (int i=0;i<number;i++){
                    System.out.print(myDouble[i]+" ");
                }
                break;
            default:
                Float[] myFloat = new Float[number];
                for (int i=0;i<number;i++){
                   myFloat[i]=sc.nextFloat();
                }
                bubbleSort(myFloat);
                for (int i=0;i<number;i++){
                    System.out.print(myFloat[i]+" ");
                }
                break;
        }
    }

    static <T extends Number & Comparable<T>> void bubbleSort(T[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].compareTo(array[j])>0) {
                    T temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    
}
