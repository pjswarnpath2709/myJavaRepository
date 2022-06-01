package TREE;

import java.util.Stack;

public class IterativeInorder {

    static void inorder(BTNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.printf(root.data + " ");
        inorder(root.right);
    }

    static void iterativeInOrder(BTNode root) {
        BTNode node = root;
        Stack<BTNode> st = new Stack<>();
        while (true) {
            if (node != null) {
                st.push(node);
                node = node.left;
            } else {
                if (st.empty()) {
                    break;
                }
                //remove the element from the stack, print it
                node = st.pop();
                System.out.print(node.data+" ");
                node = node.right;
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

        inorder(root);
        System.out.println("");
        iterativeInOrder(root);
    }
}
