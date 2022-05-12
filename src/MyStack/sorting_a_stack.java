package MyStack;

import java.util.Stack;

public class sorting_a_stack {

    static void insertInASortedStack(Stack<Integer> st, int top) {
        if (st.empty() || (!st.empty() && st.peek() < top)) {
            st.push(top);
            return;
        }
        int newTop = st.pop();
        insertInASortedStack(st, top);
        st.push(newTop);
    }

    static void sortStack(Stack<Integer> st) {
        // base case
        if (st.empty()) {
            return;
        }
        int top = st.pop();
        sortStack(st);
        insertInASortedStack(st, top);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(13);
        st.push(2);
        st.push(7);
        st.push(9);
        sortStack(st);
        while (!st.isEmpty()) {
            System.out.print(st.pop() + " ");
        }
    }
}