package MyStack;

class TwoStacks extends IOM {
    private int cap;
    private int arr[];
    private int top1, top2;

    TwoStacks(int capacity) {
        this.cap = capacity;
        arr = new int[cap];
        top1 = -1;
        top2 = cap;
    }

    //for the stack1
    public void push1(int x) {
        if (top1 + 1 < top2) {
            top1++;
            arr[top1] = x;
            return;
        }
        println("Stack1 Overflow");
    }

    public int pop1() {
        if (top1 == -1) {
            println("Stack1 underflow");
            return -1;
        }
        int data = arr[top1];
        arr[top1] = -1;
        top1--;
        return data;
    }

    //for the stack2
    public void push2(int x) {
        if (top2 - 1 == top1) {
            println("Stack2 Overflow");
            return;
        }
        top2--;
        arr[top2] = x;
    }

    public int pop2() {
        if (top2 == cap + 1) {
            println("Stack2 underflow");
            return -1;
        }
        int data = arr[top2];
        arr[top2] = -1;
        top2++;
        return data;
    }

    public int getTop1() {
        if (top1 == -1) return -1;
        return arr[top1];
    }

    public int getTop2() {
        if (top2 == cap + 1) return -1;
        return arr[top2];
    }


    public void PrintArray() {
        for (int i = 0; i < cap; i++) {
            print(arr[i] + " ");
        }
        println("");
    }

    public void Clear() {
        this.top2 = this.cap;
        this.top1 = -1;
        for (int i = 0; i < cap; i++) {
            arr[i] = -1;
        }
    }

}

public class TwoStacksInArray {
    public static void main(String[] args) {
        TwoStacks tst = new TwoStacks(5);
        tst.push1(10);
        tst.push2(20);
        tst.push1(5);
        tst.push2(25);
        tst.push1(15);
        tst.PrintArray();
        tst.pop1();
        tst.pop2();
        tst.PrintArray();
        tst.push2(30);
        tst.push2(40);
        tst.PrintArray();
        tst.Clear();
        tst.push1(100);
        tst.push2(1001);
        tst.PrintArray();
    }
}
