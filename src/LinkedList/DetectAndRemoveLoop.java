package LinkedList;

public class DetectAndRemoveLoop extends IOM {
    static void detectNRemove(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }
        //no loop found in the linked list
        if (slow != fast) {
            return;
        }
        slow = head;
        //we took this condition because we have to modify the fast.next to null to maintain the linked list
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
    }

    public static void main(String[] args) {

    }
}
