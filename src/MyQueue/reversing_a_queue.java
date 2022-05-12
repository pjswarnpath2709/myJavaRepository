package MyQueue;

import java.util.*;
import java.util.Queue;
import java.util.Stack;

class QueueA {
    Queue<Integer> sq1 = new LinkedList<>();

    void addToQ(int a) {
        sq1.add(a);
    }

    int popFromQ() {
        if (sq1.isEmpty()) {
            return -1;
        }
        int front = sq1.peek();
        sq1.poll();
        return front;
    }

    int front() {
        return (sq1.isEmpty()) ? -1 : sq1.peek();
    }

    void reverse() {
        if (sq1.isEmpty()) {
            return;
        }
        int front = sq1.peek();
        sq1.poll();
        sq1.add(front);
    }
}

class QueueB {
    static void reverse(Queue<Integer> sq) {

    }
}

public class reversing_a_queue {

    static void reverse(Queue<Integer> sq) {
        Stack<Integer> st;
        st = new Stack<>(); //st empty stack ko point kari hai
        while (!sq.isEmpty()) {
            int front = sq.peek();
            st.push(front);
            sq.poll();
        }
        while (!st.isEmpty()) {
            int top = st.peek();
            sq.add(top);
            st.pop();
        }
    }

    public static void main(String[] args) {
        Queue<Integer> sq = new LinkedList<>();
        sq.add(10);
        sq.add(5);
        sq.add(15);
        sq.add(20);
        reverse(sq);
        for (int x : sq) {
            System.out.print(x + " ");
        }
        QueueA objQ = new QueueA();
        objQ.addToQ(10);
        objQ.addToQ(20);
    }
}