package LinkedList;

public class DeleteNodeOnlyPointerGivenToIt extends IOM {
    //node to be deleted will never be the last node
    static void RemoveMiddleNode(Node listnode) {
        listnode.data = listnode.next.data;
        listnode.next = listnode.next.next;
    }
    public static void main(String[] args) {

    }
}
