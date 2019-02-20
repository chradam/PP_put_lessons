import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class Main {

    public static void measureNs(Runnable runnable) {
        long startTime = System.nanoTime();
        runnable.run();
        long estimatedTime = System.nanoTime() - startTime;
        System.out.println(": " + estimatedTime + "ns");
    }

    public static void measureMs(Runnable runnable) {
        long startTime = System.currentTimeMillis();
        runnable.run();
        long estimatedTime = System.currentTimeMillis() - startTime;
        System.out.println(": " + estimatedTime + "ms");
    }

    public static void mArray(int n) {
        Integer [] tab = new Integer[n];
        for(int i = 0;i < tab.length;i++){
            tab[i] = i;
        }
    }

    public static void mArraylistB(int n) {
        List<Integer> tab = new ArrayList<>();
        for(int i = 0;i < n;i++){
            tab.add(i);
        }
    }

    public static void mArraylistC(int n) {
        List<Integer> tab = new ArrayList<>(n);
        for(int i = 0;i < n;i++){
            tab.add(i);
        }
    }

    public static void mLinkedList(int n) {
        List<Integer> tab = new ArrayList<>();
        for(int i = 0;i < n;i++){
            tab.add(i);
        }
    }

    public void zad1() {
        int n = 100000;

        System.out.print("Array");
        measureNs(() -> mArray(n));

        System.out.print("ArraylistB");
        measureNs(() -> mArraylistB(n));

        System.out.print("ArraylistC");
        measureNs(() -> mArraylistC(n));

        System.out.print("LinkedList");
        measureNs(() -> mLinkedList(n));
    }

    public static void mSilnia(int n) {
        BigInteger silnia = new BigInteger("1");
        for (int i = 2; i < n; i++) {
            silnia = silnia.multiply(BigInteger.valueOf(i));
        }
    }

    public void zad2() {
        int n = 50000;
        System.out.print("mSilnia");
        measureMs(() -> mSilnia(n));
    }

    public void zad3() throws IOException {
        ArrayList<String> list = new ArrayList<>();

        File file = new File("file.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));

        String line;
        String[] data;
        while ((line = br.readLine()) != null) {
            data = line.split("\\W+");
            for(int i = 0;i < data.length;i++){
                if(data[i].length()>=3){
                    list.add(data[i].toLowerCase());
                }
            }
        }

        List<String> distinctElements = list.stream().distinct().collect(Collectors.toList());
        System.out.println(distinctElements.size());
    }


    public void zad4() {
        int arr[] = {12, 11, 13, 5, 6};
        int arr2[] = {12, 11, 13, 5, 6};

        // Arrays.sort(arr);

        InsertionSort ob = new InsertionSort();

        System.out.print("InserionSort");
        measureNs(() -> ob.sort(arr));

        ob.printArray(arr);

        MergeSort me = new MergeSort();
        System.out.print("MergeSort");
        measureNs(() -> me.sort(arr2, 0, arr2.length-1));

        me.printArray(arr2);
    }

    public static void main(String[] args) {
        //new Main().zad1();
        //new Main().zad2();
        try {
            new Main().zad3();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        new Main().zad4();
    }
}



