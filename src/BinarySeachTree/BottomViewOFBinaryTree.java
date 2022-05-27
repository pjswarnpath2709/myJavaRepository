package BinarySeachTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;

public class BottomViewOFBinaryTree {
    static class Pair {
        BstNode node;
        int hd;

        Pair(BstNode n, int hd) {
            this.hd = hd;
            this.node = n;
        }
    }

    static void bottomView(BstNode root) {
        if (root == null) {
            return;
        }
        TreeMap<Integer, Integer> mp = new TreeMap<>();
        Queue<Pair> qt = new LinkedList<>();
        qt.add(new Pair(root, 0));
        while (!qt.isEmpty()) {
            Pair p = qt.poll();
            BstNode curr = p.node;
            int hd = p.hd;
            mp.put(hd, curr.data);
            if (curr.left != null) {
                qt.add(new Pair(curr.left, hd - 1));
            }
            if (curr.right != null) {
                qt.add(new Pair(curr.right, hd + 1));
            }
        }

        for (Map.Entry<Integer, Integer> tv : mp.entrySet()) {
            System.out.print(tv.getValue() + " ");
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        BstNode root = new BstNode(10);
        root.left = new BstNode(20);
        root.right = new BstNode(30);
        root.left.left = new BstNode(40);
        root.left.right = new BstNode(50);
        root.right.left=new BstNode(60);
        root.right.right=new BstNode(70);
        bottomView(root);
    }
}
