package BinarySeachTree;

import java.util.TreeSet;

public class CeilingOnTheLeftSide {

    //naive solution
    static void printCeilingLeft(int arr[]) {
        System.out.print(-1 + " ");
        for (int i = 1; i < arr.length; i++) {
            int diff = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (arr[j] >= arr[i]) {
                    diff = Math.min(diff, arr[j] - arr[i]);
                }
            }
            if (diff == Integer.MAX_VALUE) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(arr[i] + diff + " ");
            }
        }
        System.out.println("");
    }

    //efficient solution
    static void printCeilingOnLeft(int arr[]) {
        TreeSet<Integer> st = new TreeSet<>();
        for (int i = 0; i < arr.length; i++) {
            Integer ceil = st.ceiling(arr[i]);
            if (ceil == null) {
                System.out.print(-1 + " ");
            } else {
                System.out.print(ceil + " ");
            }
            st.add(arr[i]);
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        int arr[] = {6, 18, 4, 5};
        printCeilingLeft(arr);

        printCeilingOnLeft(arr);

    }
}
