package TREE;

public class BurnTheBinaryTree {
    static class Distance {
        int val;

        Distance(int val) {
            this.val = val;
        }

    }

    static int res = 0;

    static int burnTime(BTNode root, int leaf, Distance dist) {
        if (root == null) {
            return 0;
        }
        if (root.data == leaf) {
            dist.val = 0;
            return 1;
        }

        Distance ldist = new Distance(-1);
        Distance rdist = new Distance(-1);
        int leftH = burnTime(root.left, leaf, ldist);
        int rightH = burnTime(root.right, leaf, rdist);

        if (ldist.val != -1) {
            dist.val = ldist.val + 1;
            res = Math.max(res, dist.val + rightH);
        }
        else if (rdist.val != -1) {
            dist.val = rdist.val + 1;
            res = Math.max(res, dist.val + leftH);
        }
        return 1 + Math.max(leftH, rightH);
    }

    public static void main(String[] args) {
        BTNode root = new BTNode(10);
        root.left = new BTNode(20);
        root.right = new BTNode(30);
        root.left.left = new BTNode(40);
        root.left.right = new BTNode(50);
        root.left.left.left = new BTNode(60);
        root.left.left.left.left = new BTNode(70);
        Distance dist = new Distance(-1);
        int leaf = 50;

        burnTime(root, leaf, dist);
        System.out.print(res);
    }
}
