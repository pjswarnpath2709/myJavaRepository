package TREE;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {


    static void levelOrder(BTNode root) {
        if (root == null) return;

        //we require a Queue
        Queue<BTNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            BTNode curr = q.poll();
            //print the current data
            System.out.print(curr.data + " ");

            //chk for the left and right children
            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }
    }

    static void levelOrderLine(BTNode root) {
        if (root == null) return;
        Queue<BTNode> qt = new LinkedList<>();
        qt.add(root);
        qt.add(null);
        while (qt.size() > 1) {
            BTNode curr = qt.poll();
            if (curr == null) {
                //current level done and next level is completely inside the queue
                System.out.println(" ");
                qt.add(null);
            } else {
                System.out.print(curr.data+" ");
                if (curr.left != null) {
                    qt.add(curr.left);
                }
                if (curr.right != null) {
                    qt.add(curr.right);
                }
            }
        }
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.right = new BTNode(20);
        root.left = new BTNode(30);
        root.left.right = new BTNode(40);
        root.left.left = new BTNode(50);
        root.right.right = new BTNode(60);
        root.right.left = new BTNode(70);

        levelOrder(root);

        System.out.println();

        levelOrderLine(root);
    }
}
