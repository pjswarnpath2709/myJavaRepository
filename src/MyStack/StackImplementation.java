package MyStack;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null; //references are by default initialised as null in the java
    }
}

//int this type of Stack the defined memory is finite
class MyStack extends IOM {
    //using the array
    private int cap;
    private int arr[];
    private int top;

    public MyStack(int capacity) {
        this.cap = capacity;
        arr = new int[cap];
        top = -1;
    }

    public int getTop() {
        return arr[top];
    }

    public int getsize() {
        return top + 1;
    }

    public void pushIn(int x) {
        if (top < cap) {
            arr[++top] = x;
            return;
        } else if (top == cap) {
            println("Stack Overflow");
        }
    }

    public int pop() {
        if (top == -1) {
            println("Stack underflow");
            return -1;
        } else {
            int data = arr[top];
            --top;
            return data;
        }
    }

    public boolean isEmpty() {
        if (top == -1) {
            return true;
        } else {
            return false;
        }
    }
}

//can use indefinite memory
class MYStackLinked {
    //using the Linked List
    private int top;
    private Node head;

    private int length;

    MYStackLinked() {
        this.head = null;
        this.length = 0;
    }

    public void push(int x) {
        Node temp = new Node(x);
        if (head == null) {
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }
        length++;
    }

    public int pop() {
        if (length == 0) {
            System.out.println("Stack Underflow");
            return -1;
        } else {
            length--;
            Node temp = head;
            head = head.next;
            temp.next = null;
            return temp.data;
        }
    }

    public int getSize() {
        return length;
    }

    public boolean isEmpty() {
        return (length == 0);
    }

    public int getTop() {
        return head.data;
    }


}

public class StackImplementation extends IOM {
    public static void main(String[] args) {
        println("Stack using Array");
        MyStack st = new MyStack(5);
        st.pushIn(20);
        st.pushIn(30);
        st.pushIn(40);
        while (!st.isEmpty()) {
            println(st.pop());
        }
        st.pushIn(3);
        st.pushIn(40);
        println("Size of the stack is : " + st.getsize());
        println("current top element in the stack is : " + st.getTop());

        println("Stack using LinkedList");
        MYStackLinked s = new MYStackLinked();
        s.push(20);
        s.push(30);
        s.push(40);
        while (!s.isEmpty()) {
            println(s.pop());
        }
        s.push(399);
        s.push(499);
        println("Size of the Stack is: " + s.getSize());
        println("current top element in the stack is : " + s.getTop());


    }
}
