package TREE;

import java.util.Stack;

public class IterativePreorder {

    static void preorder(BTNode root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }

    static void iterativePreOrder(BTNode root) {
        if (root == null) {
            return;
        }
        Stack<BTNode> st = new Stack<>();
        st.push(root);
        while (!st.isEmpty()) {
            BTNode curr = st.pop();
            // step1: print the root
            System.out.print(curr.data + " ");
            // step2 :first we will push the right first as it is a stack
            if (curr.right != null) {
                st.push(curr.right);
            }
            // step3 : secondly we will push the left first as it will be at top of the stack
            if (curr.left != null) {
                st.push(curr.left);
            }
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.right = new BTNode(20);
        root.left = new BTNode(30);
        root.left.right = new BTNode(40);
        root.left.left = new BTNode(50);
        root.right.right = new BTNode(60);
        root.right.left = new BTNode(70);

        iterativePreOrder(root);
        preorder(root);
    }
}
