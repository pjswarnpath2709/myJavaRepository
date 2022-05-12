package MyStack;

import java.util.Stack;

public class NextGreaterElement extends IOM {
    static void printNGE(int arr[], int n) {
        Stack<Integer> st = new Stack<>();
        st.push(arr[n - 1]);
        for (int i = n - 1; i >= 0; i--) {
            while (st.isEmpty() == false && st.peek() <= arr[i]) {
                st.pop();
            }
            int nextGreat = st.isEmpty() ? -1 : st.peek();
            print(nextGreat + " ");
            st.push(arr[i]);
        }
    }

    public static void main(String[] args) {
        int n = get_Int();
        int arr[] = getIntArrayPrimary(n);
        printNGE(arr, n);
    }
}
