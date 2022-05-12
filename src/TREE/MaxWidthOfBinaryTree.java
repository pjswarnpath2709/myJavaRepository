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

    }
}
