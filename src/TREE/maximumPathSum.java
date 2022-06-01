package TREE;

public class maximumPathSum {
static int maxi;
static int getMaxSum(BTNode root){
    if(root==null){
        return 0;
    }
    int leftSum = Math.max(0,getMaxSum(root.left));
    int rightSum =  Math.max(0,getMaxSum(root.right));
    maxi = Math.max(maxi,root.data+leftSum+rightSum);
    return root.data+Math.max(leftSum,rightSum);
}
static  int maxPathSum(BTNode root){
    maxi=Integer.MIN_VALUE;
    getMaxSum(root);
    return maxi;
}

    public static void main(String[] args) {
        BTNode root = new BTNode(-10);
        root.left = new BTNode(9);
        root.right = new BTNode(20);
        root.right.left = new BTNode(15);
        root.right.right = new BTNode(7);

        int answer = maxPathSum(root);
        System.out.println("The Max Path Sum for this tree is " + answer);

    }
}
