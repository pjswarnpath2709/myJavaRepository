package LinkedList;

import java.util.HashSet;
import java.util.LinkedList;


public class IntersectionPointOfTwoLinkedList extends IOM {

    static int getIntersection(Node h1, Node h2) {
        HashSet<Node> hs = new HashSet<>();
        for (Node curr = h1; curr != null; curr = curr.next) {
            hs.add(curr);
        }
        for (Node curr = h2; curr != null; curr = curr.next) {
            if (hs.contains(curr)) {
                return curr.data;
            }
        }
        return -1;
    }

    static int getIntersectionMethod2(Node h1, Node h2) {
        int count1 = 0, count2 = 0;
        for (Node curr = h1; curr != null; curr = curr.next) {
            count1++;
        }
        for (Node curr = h2; curr != null; curr = curr.next) {
            count2++;
        }
        int diff = Math.abs(count1 - count2); //find the difference
        Node curr1 = h1, curr2 = h2;
        if (count1 > count2) {
            //traverse till difference in the first Linked List
            for (int i = 0; i < diff; i++) {
                curr1 = curr1.next;
            }
        } else {
            //traverse till difference in the second Linked List
            for (int i = 0; i < diff; i++) {
                curr2 = curr2.next;
            }
        }
        //traverse simultaneously
        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2) {
                return curr1.data;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return -1;
    }

    public static void main(String[] args) {
        LList l1 = new LList();
        LList l2 = new LList();
        int n = get_Int();
        for (int i = 0; i < n; i++) {
            l1.insertBegin(get_Int());
        }
        l1.PrintList();
        println("");
        int k = get_Int();
        for (int i = 0; i < k; i++) {
            l2.insertBegin(get_Int());
        }
        l2.PrintList();
        println("");
        Node curr = l1.head;
        for (int i = 0; i < 4; i++) {
            curr = curr.next;
        }
        Node l2end = l2.head;
        while (l2end.next != null) {
            l2end = l2end.next;
        }
        l2end.next = curr;
        l2.PrintList();
        println(" answer starts from here ");
        println(getIntersection(l1.head, l2.head));
        println(getIntersectionMethod2(l1.head, l2.head));
    }
}
