package MyStack;

import java.util.*;
import java.math.*;


public class DEQUE_IMPLEMENTATION {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<Integer> dq = new LinkedList<>();
        System.out.println("start inserting in the deque : ");

        //input
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("insert front : ");
            dq.offerFirst(sc.nextInt());
            System.out.println("insert end : ");
            dq.offerLast(sc.nextInt());
        }

        //deletion
        int first_item = (dq.peekFirst() != null) ? dq.pollFirst() : -1;
        System.out.println("the first element is : " + first_item);
        int last_item = (dq.peekLast() != null) ? dq.pollLast() : -1;
        System.out.println("the last element is : " + last_item);


        //crating another queue for the other set of functions which throws exception instead
        // of the special values

        Deque<Integer> dqe = new LinkedList<>();
        System.out.println("start inserting in the deque : ");

        //input
        int n2 = sc.nextInt();
        for (int i = 0; i < n2; i++) {
            System.out.println("insert front : ");
            dqe.addFirst(sc.nextInt());
            System.out.println("insert end : ");
            dqe.addLast(sc.nextInt());
        }

        //deletion
        first_item = (dqe.getFirst() != null) ? dqe.removeFirst() : -1;
        System.out.println("the first element is : " + first_item);
        last_item = (dqe.getLast() != null) ? dqe.removeLast() : -1;
        System.out.println("the last element is : " + last_item);


    }
}
