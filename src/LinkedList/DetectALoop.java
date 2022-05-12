package LinkedList;

import java.util.HashSet;

public class DetectALoop extends IOM {
    boolean isLoop(Node head) {
        HashSet<Node> hs = new HashSet<>();
        Node curr = head;
        while (curr != null) {
            if (hs.contains(hs)) {
                return true;
            }
            hs.add(curr);
            curr = curr.next;
        }
        return false;
    }

    //the slow and fast pointer approach
    //slow moves by one and fast moves by two pointer , whenever they meet there is a loop
    boolean detectLoopByFloyd(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
