package LinkedList;


public class NthNodeFind extends IOM {
    //find Nth node from the end of the linked List
    //naive method
    static void NthNode(Node head, int pos) {
        if (head == null) {
            println("NULL");
            return;
        }
        int count = 0;
        Node curr = head;
        while (curr != null) {
            curr = curr.next;
            count++;
        }
        if (pos > count) {
            println("NULL");
            return;
        } else {
            curr = head;
            for (int i = 1; i < count - pos + 1; i++) {
                curr = curr.next;
            }
            println(curr.data);
        }
    }

    //Another Approach
    //two pointer approaches
    static void NthNodeMethod2(Node head, int pos) {
        if (head == null) return;
        Node first = head;
        for (int i = 0; i < pos; i++) {
            if (first == null) {
                println("NULL");
                return;
            }
            first = first.next;
        }
        Node second = head;
        while (first != null) {
            second = second.next;
            first = first.next;
        }
        println(second.data);
    }

    public static void main(String[] args) {
        LList l = new LList();
        int n = get_Int();
        for (int i = 0; i < n; i++) {
            int input = get_Int();
            l.insertBegin(input);
        }
    }
}

