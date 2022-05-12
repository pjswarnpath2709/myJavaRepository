package LinkedList;

public class RecRevLinkedList extends IOM {


    static Node revRecMethod1(Node head) {
        //base case
        if (head == null || head.next == null) {
            return head;
        }
        Node rest_head = revRecMethod1(head);
        Node rest_tail = head.next;
        rest_tail.next = head;
        head.next = null;
        return rest_head;
    }

    static Node revRecMethod2(Node curr, Node prev) {
        //base case
        if (curr == null) {
            return prev;
        }
        Node next = curr.next;
        curr.next = prev;
        return revRecMethod2(next, curr);
    }

    public static void main(String[] args) {
        LList l = new LList();
        int n = get_Int();
        for (int i = 0; i < n; i++) {
            int input = get_Int();
            l.insertBegin(input);
        }
        l.PrintList();
        l.head = revRecMethod1(l.head);
        println(" ");
        l.PrintList();
    }
}
