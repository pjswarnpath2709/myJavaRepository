package LinkedList;

public class ReverseInTheGroups extends IOM {

    public static Node reverseK(Node head, int k) {
        Node curr = head, prevFirst = null;
        Node prev = null, next = null;
        int count = 0;
        while (curr != null && count < k) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (next != null) {
            Node rest_head = reverseK(next, k);
            head.next = rest_head;
        }
        return prev; //prev will be the new head
    }

    public static Node reverseKItr(Node head, int k) {
        Node curr = head, prevFirst = null;
        boolean firstPass = true;
        Node prev = null, next = null;
        while (curr != null) {
            Node first = curr;
            prev = null;
            int count = 0;
            while (curr != null && count < k) {
                next = curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
                count++;
            }
            if (firstPass) {
                head = prev;
                firstPass = false;
            } else {
                prevFirst.next = prev;
            }
            prevFirst = first;
        }
        return head;
    }

    public static void main(String[] args) {
        LList l = new LList();
        int n = get_Int();
        println(n);
        int k = get_Int();
        println(k);
        for (int i = 0; i < n; i++) {
            int input = get_Int();
            l.insertBegin(input);
        }
        l.PrintList();
        println(" ");
        l.head = reverseKItr(l.head, k);
        l.PrintList();
    }
}
