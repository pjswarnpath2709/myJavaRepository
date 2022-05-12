package MyQueue;

class NodeL {
    int data;
    NodeL next;

    NodeL(int x) {
        this.data = x;
        this.next = null;
    }
}

class Queue {
    NodeL front, rear;
    int size;

    Queue() {
        this.front = null;
        this.rear = null;
        this.size = 0;
    }

    void enqueue(int x) {
        NodeL temp = new NodeL(x);            //creating a temp NodeL
        //if front is equal to null then that means that the queue is empty and both front and rear are = to temp
        if (front == null) {
            front = rear = temp;
            size++;
            return;
        }
        rear.next = temp;        //here temp will become rear ka next NodeL 
        rear = temp;

        size++;
    }

    void dequeue() {
        //it means that the queue is empty
        if (front == null) {
            return;
        }
        front = front.next;               //here front ka next will now become front
        size--;
        if (front == null) {
            rear = null;
        }
    }
}

public class implementation_using_linked_list {
    public static void main(String[] args) {
        Queue q = new Queue();
        q.enqueue(10);
        q.enqueue(20);
        System.out.println(q.front.data);
        System.out.println(q.rear.data);
        System.out.println(q.size);
        q.dequeue();
        q.dequeue();
        //System.out.println(q.size);
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);
        q.dequeue();
    }
}