package TREE;

import java.util.LinkedList;
import java.util.Queue;

public class MaxWidthOfBinaryTree {

    static int getMaxWidth(BTNode root) {
        if (root == null) {
            return 0;
        }
        Queue<BTNode> qt = new LinkedList<>();
        int res = 0;
        qt.add(root);
        while (!qt.isEmpty()) {

            int size = qt.size();
            res = Math.max(res, size);
            for (int i = 0; i < size; i++) {
                BTNode curr = qt.poll();
                if (curr.left != null) qt.add(curr.left);
                if (curr.right != null) qt.add(curr.right);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.right = new BTNode(20);
        root.left = new BTNode(30);
        root.left.right = new BTNode(40);
        root.left.left = new BTNode(50);
        root.right.right = new BTNode(60);
        root.right.left = new BTNode(70);

        System.out.println(getMaxWidth(root));
    }
}
