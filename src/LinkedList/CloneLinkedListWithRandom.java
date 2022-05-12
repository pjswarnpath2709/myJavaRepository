package LinkedList;

import java.util.HashMap;

class RandNode {
    int data;
    RandNode next;
    RandNode random;

    RandNode(int x) {
        this.data = x;
        this.random = null;
        this.next = null;
    }
}

public class CloneLinkedListWithRandom extends IOM {
    static RandNode cloneWithRandomHashing(RandNode head) {
        HashMap<RandNode,RandNode> hm=new HashMap<RandNode,RandNode>();
        for(RandNode curr=head;curr!=null;curr=curr.next)
            hm.put(curr,new RandNode(curr.data));

        for(RandNode curr=head;curr!=null;curr=curr.next){
            RandNode cloneCurr=hm.get(curr);
            cloneCurr.next=hm.get(curr.next);
            cloneCurr.random=hm.get(curr.random);
        }
        return hm.get(head);
    }

    static RandNode cloneWithRandom(RandNode head) {
        //step one
        for (RandNode curr = head; curr != null; ) {
            RandNode next = curr.next;
            curr.next = new RandNode(curr.data);
            curr.next.next = next;
            curr = next;
        }
        //step two
        for (RandNode curr = head; curr != null; curr = curr.next.next) {
            curr.next.random = (curr.random != null) ? curr.random.next : null;
        }
        //step three delete all the alternative nodes
        RandNode original = head, copy = head.next;
        RandNode temp = copy;
        while (original != null && copy != null) {
            original.next = original.next != null ? original.next.next : original.next;
            copy.next = copy.next != null ? copy.next.next : copy.next;
            original = original.next;
            copy = copy.next;
        }
        return temp;
    }

    public static void printItBaby(RandNode start) {
        RandNode ptr = start;
        while (ptr != null) {
            System.out.println("Data = " + ptr.data + ", Random  = " + ptr.random.data);
            ptr = ptr.next;
        }
    }

    public static void main(String[] args) {
        RandNode head = new RandNode(10);
        head.next = new RandNode(5);
        head.next.next = new RandNode(20);
        head.next.next.next = new RandNode(15);
        head.next.next.next.next = new RandNode(20);

        head.random = head.next.next;
        head.next.random = head.next.next.next;
        head.next.next.random = head;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head.next.next.next;

        System.out.print("Original list : \n");
        printItBaby(head);

        System.out.print("\nCloned list : \n");
        RandNode cloned_list = cloneWithRandom(head);
        printItBaby(cloned_list);
    }
}
