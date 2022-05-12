package LinkedList;

import java.util.ArrayList;
import java.util.HashMap;

class Dnode {
    Dnode next;
    int data;
    Dnode prev;

    Dnode(int x) {
        this.data = x;
        this.next = null;
        this.prev = null;
    }
}

class DLList {
    Dnode head;
    Dnode tail;

    void insertAtHead(int x) {
        Dnode temp = new Dnode(x);
        if (head == null) {
            head = tail = temp;
            return;
        }
        temp.next = head;
        head.prev = temp;
        head = temp;
    }

    void deleteGivenNode(Dnode pos) {
        pos.prev.next = pos.next;
        pos.next.prev = pos.prev;
    }

    void moveGivenNodeAtFirst(Dnode pos) {
        //take the node ,delete it and push it in the front
        int data = pos.data;
        //if the node is not a tail
        if (pos != tail) {
            deleteGivenNode(pos);
            insertAtHead(pos.data);
            return;
        }
        Dnode temp = new Dnode(tail.data);
        deleteLastNode();
        temp.next = head;
        head.prev = temp;
        head = temp;

    }

    void deleteLastNode() {
        Dnode temp = tail;
        tail = temp.prev;
        tail.next = null;
        //isolate kar diya temp ko taki koi dikkat na aye
        temp.prev = null;
        temp.next = null;
    }

    Dnode getHead() {
        return head;
    }

    Dnode getTail() {
        return tail;
    }
}

class LRUCacheStructure {
    private int capacity;
    public DLList list;
    HashMap<Integer, Dnode> hm;

    LRUCacheStructure(int cap) {
        this.capacity = cap;
        this.hm = new HashMap<>();
        this.list = new DLList();
    }

    void Refer(int x) {
        //if it is  present in the hashmap then we have to move it to front
        if (hm.containsKey(x)) {
            if (hm.get(x) != list.head) {
                list.moveGivenNodeAtFirst(hm.get(x));
            }
        } else {
            if (capacity == hm.size()) {
                hm.remove(list.tail.data);
                list.deleteLastNode();
            }
            list.insertAtHead(x);
            hm.put(x, list.head);
        }
    }
}

public class LRUCacheDesign extends IOM {
    static void printList(Dnode head) {
        for (Dnode curr = head; curr != null; curr = curr.next) {
            print(curr.data + " ");
        }
    }

    public static void main(String[] args) {
        LRUCacheStructure struct = new LRUCacheStructure(4);
        ArrayList<Integer> arr = new ArrayList<>();
        int n = get_Int();
        for (int i = 0; i < n; i++) {
            arr.add(get_Int());
        }
        for (Integer integer : arr) {
            struct.Refer(integer);
            printList(struct.list.head);
            println("");
        }
    }
}
/*
input--->
11
10 20 10 30 40 50 30 40 60 30 30

*/