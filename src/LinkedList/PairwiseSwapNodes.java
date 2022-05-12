package LinkedList;

public class PairwiseSwapNodes extends IOM {

    static void swapData(Node head) {
        //data swapping in the Objects can be a Very Heavy Operation
        //therefore this method is used for the Light Weighted Objects
        Node curr = head;
        while (curr != null && curr.next != null) {
            int temp = curr.data;
            curr.data = curr.next.data;
            curr.next.data = temp;
            curr = curr.next.next;
        }
    }

    static Node swapLinks(Node head) {
        if (head == null || head.next == null) return head;
        Node curr = head.next.next;
        Node prev = head;
        head = head.next;
        head.next = prev;
        while (curr != null && curr.next != null) {
            prev.next = curr.next;
            prev = curr;
            Node nexti = curr.next.next;
            curr.next.next = curr;
            curr = nexti;
        }
        prev.next = curr;
        return head;
    }

    public static void main(String[] args) {
        LList l = new LList();
        int n = get_Int();
        for (int i = 0; i < n; i++) {
            int input = get_Int();
            l.insertBegin(input);
        }
        l.PrintList();
        l.head=swapLinks(l.head);
        println(" ");
        l.PrintList();
    }
}
