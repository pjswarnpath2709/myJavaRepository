package LinkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ReverseTheLinkedList extends IOM {
    public static Node reverseList(Node head) {
        if (head == null) {
            return null;
        }
        int len = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            len++;
        }
        int arr[] = new int[len];
        curr = head;
        for (int i = 0; i < len; i++) {
            arr[i] = curr.data;
            curr = curr.next;
        }
        curr = head;
        for (int i = len - 1; i >= 0; i--) {
            curr.data = arr[i];
            curr = curr.next;
        }
        return head;
    }


    public static Node changeLinks(Node head) {
        if (head == null) {
            return null;
        }
        Node prev = null;
        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;    //current ke next ko previous banaya
            prev = curr;        //previous ko utha kar current pe laya
            curr = next;       //current ko next pe shift karaya
        }
        return prev; //prev will become the new head
    }

    public static void main(String[] args) {
        int n = get_Int();
        LList l = new LList();
        for (int i = 0; i < n; i++) {
            int input = get_Int();
            l.insertBegin(input);
        }
        l.PrintList();
        l.head = changeLinks(l.head);
        println(" ");
        l.PrintList();
    }
}
