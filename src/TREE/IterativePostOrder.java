package TREE;

import java.util.Stack;

public class IterativePostOrder {
    static void postorder(BTNode root) {
        if (root != null) {

            postorder(root.left);
            postorder(root.right);
            System.out.print(root.data + " ");
        }
    }

    static void iterativePostOrder2Stacks(BTNode root) {
        BTNode node = root;
        Stack<BTNode> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        st1.push(node);
        while (!st1.isEmpty()) {
            node = st1.pop();
            st2.push(node.data);
            if (node.left != null) {
                st1.push(node.left);
            }
            if (node.right != null) {
                st1.push(node.right);
            }
        }
        while (!st2.isEmpty()) {
            System.out.print(st2.pop() + " ");
        }
        System.out.println();
        System.out.println("iterativePostOrder2stack");

    }

    static void iterativePostOrder1Stack(BTNode root) {
        if(root==null){
            return;
        }
        BTNode curr = root;
        Stack<BTNode> st = new Stack<>();
        while ( curr != null || !st.isEmpty()) {

            if (curr != null) {
                //iska left subtree stack ke andar push karo
                st.push(curr);
                curr = curr.left;
            } else {
                /*
                 *  ab apna jo left subtree hai woh poora ke poora
                 * stack ke andar hoga , so now it's time to explore right
                 * subtree's of all nodes present in the stack
                 * */
                BTNode temp = st.peek().right;
                if (temp == null) {
                    //agar right bhi null hai yani apan leaf node pe khade hai
                    //ise toh apan ko print karna hai
                    temp = st.pop();
                    System.out.print(temp.data+" ");
                    while (!st.isEmpty() && temp == st.peek().right) {
                        /*
                        ab jab tak temp kisi ka right child hai yani jo
                        temp ka parent rahega woh already stack mein present hoga
                        aur uska right side explore ho chuka hoga already therefore ab
                        usko nikal ke print kardo aur uske root pe le ao
                        */
                        temp = st.pop();
                        System.out.print(temp.data+" ");
                    }
                } else {

                    //iska left tree stack ke andar push karo
                    curr=temp; //yaha pe apan ek kadam right mein agaye aur ise stack
                    // mein push kardiya
                }
            }
        }
        System.out.println();
        System.out.println("iterativePostOrder1stack");
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.right = new BTNode(20);
        root.left = new BTNode(30);
        root.left.right = new BTNode(40);
        root.left.left = new BTNode(50);
        root.right.right = new BTNode(60);
        root.right.left = new BTNode(70);
        postorder(root);
        System.out.println();
        System.out.println("postorder done");
        System.out.println("--------------------");
        iterativePostOrder1Stack(root);
        System.out.println("--------------------");
        iterativePostOrder2Stacks(root);
    }
}
