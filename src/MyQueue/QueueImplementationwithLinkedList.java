package MyQueue;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedListQueue extends IOM {
    private Node front;
    private Node rear;
    private int size;

    LinkedListQueue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    //insert in the queue from the back
    public void Enqueue(int data) {
        Node temp = new Node(data);
        size++;
        if (front == rear) {
            //first element
            front = rear = temp;
            return;
        }
        rear.next = temp;
        rear = temp;

    }

    //remove an element from the front
    public int Deqeue() {
        //delete from the front
        if (isEmpty()) {
            return -1;
        }
        size--;
        Node temp = front;
        front = front.next;
        temp.next = null;
        if(front==null){
            rear=null;
        }
        return temp.data;
    }

    //to print the linked list
    public void printQueue() {
        Node curr = front;
        while (curr != null) {
            print(curr.data + " ");
            curr = curr.next;
        }
    }

    //check if the queue is empty or not
    public boolean isEmpty() {
        if (front == rear && front == null) {
            return true;
        }
        return false;
    }

    //get the size of the queue
    public int getSize() {
        return size;
    }

    //get the front element of the queue
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return front.data;
    }

    //get the last element of the queue
    public int getBack() {
        if (isEmpty()) {
            return -1;
        }
        return rear.data;
    }

}


public class QueueImplementationwithLinkedList extends IOM {
    public static void main(String[] args) {

    }
}
