package MyStack;


import java.util.Stack;

public class StockSpanProblem extends IOM {
    static void printSpan(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            int span = 1;
            for (int j = i - 1; j >= 0 && arr[j] <= arr[i]; j--) {
                span++;
            }
            print(span + " ");
        }
    }

    static void printSpanUsingStack(int arr[], int n) {
        //span =Index of the element - Previous Closest greater Element  -->if greater element on the left side
        //Index + 1 --->if no greater element on the left exists
        Stack<Integer> st = new Stack<>();
        st.push(0);
        print(1);
        for (int i = 1; i < n; i++) {
            while (st.isEmpty() == false && arr[st.peek()] <= arr[i]) {
                st.pop();
            }
            int span = st.isEmpty() ? i + 1 : -st.peek();
            print(span);
            st.push(i);
        }

    }

    public static void main(String[] args) {
        int n = get_Int();
        int arr[] = getIntArrayPrimary(n);
        printSpanUsingStack(arr, n);

    }
}
