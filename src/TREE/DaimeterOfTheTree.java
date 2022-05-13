package TREE;

import java.util.HashMap;

public class DaimeterOfTheTree {
    static HashMap<BTNode, Integer> mp = new HashMap<BTNode, Integer>();

    static int getHeight(BTNode root) {
        if (root == null) {
            mp.put(root, 0);
            return 0;
        }
        int lh = (mp.containsKey(root.left)) ? mp.get(root.left) : getHeight(root.left);
        int rh = (mp.containsKey(root.right)) ? mp.get(root.right) : getHeight(root.right);

        mp.put(root, 1 + Math.max(lh, rh));

        return 1 + Math.max(lh, rh);

    }

    static int getDaimeter(BTNode root) {
        if (root == null) {
            return 0;
        }
        int d1 = 1 + getHeight(root.left) + getHeight(root.right);
        int d2 = getDaimeter(root.left);
        int d3 = getDaimeter(root.right);
        return Math.max(d1, Math.max(d2, d3));
    }


    static int getDaimeterMap(BTNode root) {
        if (root == null) {
            return 0;
        }
        int d1 = 1 + mp.get(root.left) + mp.get(root.right);
        int d2 = getDaimeterMap(root.left);
        int d3 = getDaimeterMap(root.right);

        return Math.max(d1, Math.max(d2, d3));

    }

    static int res = 0;

    static int getDaimeterModified(BTNode root) {
        if (root == null) return 0;

        int lh = getDaimeterModified(root.left);
        int rh = getDaimeterModified(root.right);

        res = Math.max(res, 1 + lh + rh);
        return 1 + Math.max(lh, rh);
    }

    static int getDaimeterRes(BTNode root) {
        int heigth = getDaimeterModified(root);
        return res;
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.left = new BTNode(20);
        root.right = new BTNode(30);
        root.right.left = new BTNode(40);
        root.right.right = new BTNode(60);
        root.right.left.left = new BTNode(50);
        root.right.right.right = new BTNode(70);

        System.out.println("Height: " + getHeight(root));
        System.out.println("Diameter: " + getDaimeterRes(root));

        System.out.println("Diameter with Mapped Height: " + getDaimeterMap(root));
        System.out.println("Diameter with normal Height: " + getDaimeter(root));
    }
}
