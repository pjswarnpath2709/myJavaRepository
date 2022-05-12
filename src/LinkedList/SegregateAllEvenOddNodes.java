package LinkedList;

public class SegregateAllEvenOddNodes extends IOM {
    static Node myMethod(Node head) {
        Node evenStart = null, evenEnd = null;
        Node oddStart = null, oddEnd = null;
        boolean evenFirst = false;
        boolean oddFirst = false;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            if (curr.data % 2 == 0) {
                if (!evenFirst) {
                    evenFirst = true;
                    evenStart = curr;
                    evenEnd = curr;
                }
                curr.next = null;
                evenEnd.next = curr;
                evenEnd = evenEnd.next;
            }
            if (curr.data % 2 == 1) {
                if (!oddFirst) {
                    oddFirst = true;
                    oddStart = curr;
                    oddEnd = curr;
                }
                curr.next = null;
                oddEnd.next = curr;
                oddEnd = curr;
            }
            curr = next;
        }
        if (oddStart == null || evenStart == null) {
            return head;
        }
        evenEnd.next = oddStart;
        oddEnd.next = null;
        return evenStart;
    }

    public static void main(String[] args) {
        LList l = new LList();
        int n = get_Int();
        for (int i = 0; i < n; i++) {
            int x = get_Int();
            l.insertBegin(x);
        }
        l.PrintList();
        l.head = myMethod(l.head);
        println("");
        l.PrintList();
    }
}
