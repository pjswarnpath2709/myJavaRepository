package TREE;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralTraversalOfTree {
    static void printSpiralLine(BTNode root) {
        if (root == null) {
            return;
        }
        Queue<BTNode> qt = new LinkedList<>();
        boolean isReverse = false;
        Stack<Integer> st = new Stack<>();
        qt.add(root);
        while (!qt.isEmpty()) {
            int size = qt.size();
            for (int i = 0; i < size; i++) {
                BTNode curr = qt.poll();
                if (isReverse) {
                    assert curr != null;
                    st.push(curr.data);
                } else {
                    assert curr != null;
                    System.out.print(curr.data + " ");
                }
                if (curr.left != null) qt.add(curr.left);
                if (curr.right != null) qt.add(curr.right);
            }
            //for loop ke bahar likhna hai ise
            if (isReverse) {
                while (!st.isEmpty()) {
                    System.out.print(st.pop()+" ");
                }
            }
            isReverse = (!isReverse);
        }

    }

    static void printSpiralStacks(BTNode root) {
        if (root == null) return;

        Stack<BTNode> st1 = new Stack<>();
        Stack<BTNode> st2 = new Stack<>();
        st1.push(root);

        while (!st1.isEmpty() || !st2.isEmpty()) {
            while (!st1.isEmpty()) {
                BTNode curr = st1.pop();
                System.out.print(curr.data+" ");
                if (curr.left != null) {
                    st2.push(curr.left);
                }
                if (curr.right != null) {
                    st2.push(curr.right);
                }
            }
            while (!st2.isEmpty()) {
                BTNode curr = st2.pop();
                System.out.print(curr.data+" ");
                if (curr.right != null) {
                    st1.push(curr.right);
                }
                if (curr.left != null) {
                    st1.push(curr.left);
                }
            }
        }

    }

    public static void main(String[] args) {
        BTNode root = new BTNode(1);
        root.left = new BTNode(2);
        root.right = new BTNode(3);
        root.left.left = new BTNode(4);
        root.left.right = new BTNode(5);
        root.right.left = new BTNode(6);
        root.right.right = new BTNode(7);

        printSpiralLine(root);
        System.out.println("");
        printSpiralStacks(root);
    }
}
