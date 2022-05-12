package LinkedList;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null; //references are by default initialised as null in the java
    }
}

class LList extends IOM {
    Node head;

    void insertBegin(int x) {
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
    }

    void PrintList() {
        Node curr = head;
        while (curr != null) {
            print(curr.data + " ");
            curr = curr.next;
        }
    }

    void insertEnd(int x) {
        Node curr = head;
        if (head == null) {
            head = new Node(x);
            return;
        }
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = new Node(x);
    }
}

public class LinkedListIntro extends IOM {
    //print the node's Middle
    //naive Approach
    static void printMiddle(Node head) {
        if (head == null) {
            return;
        }
        Node curr = head;
        int count = 0;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        curr = head;
        for (int i = 0; i < count / 2; i++) {
            curr = curr.next;
        }
        println(curr.data);

    }

    //Efficient approach
    static void printMiddleEff(Node head) {
        if (head == null) {
            return;
        }
        Node slow = head; //move one node at a time
        Node fast = head; //move two n odes at a time
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        println(slow.data);
    }


    //two pointer refrences

    public static void main(String[] args) {
        LList l = new LList();
        int n = get_Int();
        for (int i = 0; i < n; i++) {
            int input = get_Int();
            l.insertBegin(input);
        }
        printMiddle(l.head);
        printMiddleEff(l.head);
    }
}


class IOM {
    //print Any object
    static void print(Object ob) {
        System.out.print(ob.toString());
    }

    //print array
    static void printArray(Object[] arr) {
        for (Object ob : arr) {
            System.out.print(ob.toString() + " ");
        }
        println("");
    }

    //print array for primary int
    static void printArray(int[] arr) {
        for (int i : arr) {
            print(i);
        }
        println("");
    }

    //print array for primary char
    static void printArray(char[] arr) {
        for (char i : arr) {
            print(i);
        }
        println("");
    }

    //print array for primary float
    static void printArray(float[] arr) {
        for (float i : arr) {
            print(i);
        }
        println("");
    }

    //print array for primary double
    static void printArray(double[] arr) {
        for (double i : arr) {
            print(i);
        }
        println("");
    }

    //print array for primary long
    static void printArray(long[] arr) {
        for (long i : arr) {
            print(i);
        }
        println("");
    }

    //print array for primary boolean
    static void printArray(boolean[] arr) {
        for (boolean i : arr) {
            print(i);
        }
        println("");
    }

    //print Anything in next line
    static void println(Object ob) {
        System.out.println(ob.toString());
    }

    //input variable
    static Scanner sc = new Scanner(System.in); //global variable

    //get an integer
    static public Integer get_Int() {
        Integer ans = sc.nextInt();
        return ans;
    }

    //get a Long
    static Long get_Long() {
        Long ans = sc.nextLong();
        return ans;
    }

    //get a Double
    static Double get_Double() {
        Double ans = sc.nextDouble();
        return ans;
    }

    //get a Float
    static Float get_Float() {
        Float ans = sc.nextFloat();
        return ans;
    }

    //get a String
    static String get_String() {
        String ans = sc.next();
        return ans;
    }

    //get a boolean
    static Boolean get_bool() {
        Boolean ans = sc.nextBoolean();
        return ans;
    }

    //get a Line as a string
    static String get_Line() {
        String s = sc.nextLine();
        return s;
    }

    //get a BigInteger
    static BigInteger get_bigInt() {
        BigInteger ans = sc.nextBigInteger();
        return ans;
    }

    //get a BigDecimal
    static BigDecimal get_bigDecimal() {
        BigDecimal ans = sc.nextBigDecimal();
        return ans;
    }

    //get a Character
    static Character get_Char() {
        Character ans = sc.next().charAt(0);
        return ans;
    }

    //take Integer Array as an Input
    static Integer[] getIntArray(int n) {
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    //take Long Array as Input
    static Long[] getLongArray(int n) {
        Long[] arr = new Long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        return arr;
    }

    //take String Array as Input
    static String[] getStringArray(int n) {
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        return arr;
    }

    //get Character Array
    static Character[] getCharArray(int n) {
        Character[] arr = new Character[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next().charAt(0);
        }
        return arr;
    }

    //get Double Array
    static Double[] getDoubleArray(int n) {
        Double[] arr = new Double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextDouble();
        }
        return arr;
    }

    //get a Boolean Array
    static Boolean[] getBooleanArray(int n) {
        Boolean[] arr = new Boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = get_bool();
        }
        return arr;
    }

    //get a  BigDecimal Array
    static BigDecimal[] getBigDecimalArray(int n) {
        BigDecimal[] arr = new BigDecimal[n];
        for (int i = 0; i < n; i++) {
            arr[i] = get_bigDecimal();
        }
        return arr;
    }

    //get a BigInteger Array
    static BigInteger[] getBigIntegerArray(int n) {
        BigInteger[] arr = new BigInteger[n];
        for (int i = 0; i < n; i++) {
            arr[i] = get_bigInt();
        }
        return arr;
    }

    //now we will overload this methods
    static int[] getIntArrayPrimary(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = get_Int();
        }
        return arr;
    }

    static float[] getFloatArrayPrimary(int n) {
        float[] arr = new float[n];
        for (int i = 0; i < n; i++) {
            arr[i] = get_Float();
        }
        return arr;
    }

    static long[] getLongArrayPrimary(int n) {
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = get_Long();
        }
        return arr;
    }

    static double[] getDoubleArrayPrimary(int n) {
        double[] arr = new double[n];
        for (int i = 0; i < n; i++) {
            arr[i] = get_Double();
        }
        return arr;
    }

    static char[] getCharArrayPrimary(int n) {
        char[] arr = new char[n];
        for (int i = 0; i < n; i++) {
            arr[i] = get_Char();
        }
        return arr;
    }

    static boolean[] getBooleanArrayPrimary(int n) {
        boolean[] arr = new boolean[n];
        for (int i = 0; i < n; i++) {
            arr[i] = get_bool();
        }
        return arr;
    }
}