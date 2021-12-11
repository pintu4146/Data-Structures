/*In a Balanced Binary Tree for every node,
the difference between heights of left subtree and right subtree should not be more than one.
In this video we discuss two solutions (one with time complexity of O(n^2)
and another with time complexity of O(n) ) to check whether a Tree is Balanced or not.*/

public class checkBalancedBT {
    public  static void main(String[] args)
    {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(20);
        root.right=new TreeNode(30);
        root.right.right=new TreeNode(60);
        root.left.left=new TreeNode(40);
        root.left.right=new TreeNode(50);
        root.left.right.left=new TreeNode(70);
        root.left.right.right=new TreeNode(80);
       int h= height(root);
       System.out.println(h);
       boolean res=isBalancedBT(root);
       System.out.println("Is balanced or Not(Naive solution): "+res);
       int result=isBalance(root);
        if(result > 0) System.out.println("Balanced");
        else System.out.println("Not Balanced");

    }

    private static int isBalance(TreeNode root) {
        if(root == null) return  0;
        int l=isBalance(root.left);
        if (l == -1) return  -1;
        int r=isBalance(root.right);
        if(r == -1) return -1;
        int diff=Math.abs(l-r);
        if(diff>1)  return  -1;
        else return (1+Math.max(l,r));
    }

    private static boolean isBalancedBT(TreeNode root) {
        if (root == null)  return true;
        int l=height(root.left);
        int r=height(root.right);
        int diff=Math.abs(l-r);
        return (diff<=1 && isBalancedBT(root.right) && isBalancedBT(root.left));
    }

    private static int  height(TreeNode root) {
        if(root == null) return 0;
        return  (1+Math.max(height(root.left),height(root.right)));
    }
}
