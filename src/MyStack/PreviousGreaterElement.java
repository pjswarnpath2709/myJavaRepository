package MyStack;

import java.util.Stack;

public class PreviousGreaterElement extends IOM {
    static void printPreviousGreater(int arr[], int n) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (st.isEmpty() == false && st.peek() <= arr[i]) {
                st.pop();
            }
            int prevGreat = st.isEmpty() ? -1 : st.peek();
            print(prevGreat + " ");
            st.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int n = get_Int();
        int arr[] = getIntArrayPrimary(n);
        printPreviousGreater(arr, n);
    }
}
