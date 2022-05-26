package BinarySeachTree;

class AgmNode {
    int data;
    AgmNode left;
    AgmNode right;
    int leftCount;

    AgmNode(int key) {
        this.data = key;
        this.left = null;
        this.right = null;
        this.leftCount = 0;
    }
}

class AgmBST {
    private AgmNode root = null;

    public void insertNode(int key) {
        root = insertAgmBst(key);
    }

    private AgmNode insertAgmBst(int key) {
        if (root == null) {
            root = new AgmNode(key);
            return root;
        }
        AgmNode prev = null;
        AgmNode curr = root;
        while (curr != null) {
            prev = curr;
            if (curr.data < key) {
                curr = curr.right;
            } else if (curr.data > key) {
                curr.leftCount++;
                curr = curr.left;
            } else {
                return root;
            }
        }
        if (prev.data > key) {
            prev.left = new AgmNode(key);
        } else {
            prev.right = new AgmNode(key);
        }
        return root;
    }

    private AgmNode getSuccesor(AgmNode node) {
        //get the right child
        AgmNode curr = node.right;
        //find it's leftmost child
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    private AgmNode DeleteAgmBst(AgmNode droot, int key) {
        if (droot == null) {
            return null;
        }
        if (droot.data < key) {
            droot.right = DeleteAgmBst(droot.right, key);
        } else if (droot.data > key) {
            droot.leftCount--;
            droot.left = DeleteAgmBst(droot.left, key);
        } else {
            if (droot.left == null) {
                return droot.right;
            } else if (droot.right == null) {
                return droot.left;
            } else {
                AgmNode succ = getSuccesor(droot);
                droot.data = succ.data;
                droot.right = DeleteAgmBst(droot.right, succ.data);
            }
        }
        return droot;
    }

    public void deleteNode(int key) {
        root = DeleteAgmBst(root, key);
    }

    private AgmNode getKthSmallestEle(AgmNode droot, int k) {
        if (droot.leftCount + 1 == k) {
            return droot;
        } else if (droot.leftCount + 1 > k) {
            return getKthSmallestEle(droot.left, k);
        } else {
            return getKthSmallestEle(droot.right, k - droot.leftCount - 1);
        }
    }

    int getKthSmallest(int k) {
        return getKthSmallestEle(root, k).data;
    }

    private void inorderTraversel(AgmNode droot) {
        if (droot != null) {
            inorderTraversel(droot.left);
            System.out.print(droot.data + " ");
            inorderTraversel(droot.right);
        }
    }

    public void printTree() {
        if (root == null) {
            System.out.println("EMPTY TREE");
        }
        inorderTraversel(root);
    }
}


public class KthSmallestElementInBST {
    public static void main(String[] args) {
        AgmBST t = new AgmBST();
        t.insertNode(50);
        t.insertNode(20);
        t.insertNode(10);
        t.insertNode(40);
        t.insertNode(4);
        t.insertNode(100);
        t.insertNode(70);
        t.insertNode(120);
        t.insertNode(60);
        t.insertNode(80);
        t.printTree();
        int ans = t.getKthSmallest(7);
        System.out.println(" ");
        System.out.println(ans);
        t.deleteNode(70);
        t.printTree();
        ans = t.getKthSmallest(7);
        System.out.println(" ");
        System.out.println(ans);
    }
}
