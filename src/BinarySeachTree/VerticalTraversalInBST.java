package BinarySeachTree;

import java.util.*;

public class VerticalTraversalInBST {

    static class Pair {
        BstNode node;
        int distance;

        Pair(BstNode root, int distance) {
            this.node = root;
            this.distance = distance;
        }
    }

    static void vTraversal(BstNode root) {
        if (root == null) {
            return;
        }
        Queue<Pair> qt = new LinkedList<>();
        TreeMap<Integer, ArrayList<Integer>> mp = new TreeMap<>();
        qt.add(new Pair(root, 0));
        while (!qt.isEmpty()) {
            Pair p = qt.poll();
            BstNode curr = p.node;
            int dist = p.distance;
            if (mp.containsKey(dist)) {
                mp.get(dist).add(curr.data);
            } else {
                ArrayList<Integer> al = new ArrayList<>();
                al.add(curr.data);
                mp.put(dist, al);
            }
            if (curr.left != null) {
                qt.add(new Pair(curr.left, dist - 1));

            }
            if (curr.right != null) {
                qt.add(new Pair(curr.right, dist + 1));
            }
        }
        for (Map.Entry<Integer, ArrayList<Integer>> p : mp.entrySet()) {
            ArrayList<Integer> al = p.getValue();
            for (int x : al)
                System.out.print(x + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        BstNode root = new BstNode(10);
        root.left = new BstNode(20);
        root.right = new BstNode(30);
        root.left.left = new BstNode(40);
        root.left.right = new BstNode(50);
        vTraversal(root);
    }
}
