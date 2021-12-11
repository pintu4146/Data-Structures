/*Size of Binary Tree is the total numbers of nodes present in that Tree.
In this video, we discuss a recursive function that takes root as a
parameter and is supposed to return the size of the Tree whose nodes are given.*/


import java.util.LinkedList;
import java.util.Queue;

public class sizeWidthOfBT {
    private static int count;

    public static  void  main(String[] args)
    {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(20);
        root.right=new TreeNode(30);
        root.right.right=new TreeNode(60);
        root.left.left=new TreeNode(40);
        root.left.right=new TreeNode(50);
        root.left.right.left=new TreeNode(70);
        root.left.right.right=new TreeNode(80);
        sizeBT(root);
        System.out.println(count);
        int size=getSize(root);
        System.out.println(size);
        int max=getMax(root);
        System.out.println("Max node of tree(Recurssive sol) "+max);
        int itrativeMax=itretvMGetMax(root);
        System.out.println("Max node of tree(iterative sol) "+max);
        int TreeWidth=widthTree(root);
        System.out.println("Width of the Tree "+TreeWidth);

    }
//************************************************************************************************************
    private static int widthTree(TreeNode root) {
        int max=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (q.size()>0)
        {
           int  qSize= q.size();
           max=Math.max(max,qSize);
           for (int i=0;i<q.size();i++)
           {
               TreeNode curr=q.poll();
               if(curr.left != null) q.add(curr.left);
               if(curr.right != null) q.add(curr.right);
           }
        }
        return max;
    }
//*****************************************************************************************
    private static int itretvMGetMax(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        int max=Integer.MIN_VALUE;
        q.add(root);
        while (q.isEmpty()==false)
        {
            TreeNode curr=q.poll();
            max=Math.max(max,curr.data);
            if (curr.left !=null) q.add(curr.left);
            if (curr.right !=null) q.add(curr.right);

        }
        return max;
    }
//******************************************************************************************
    private static int getMax(TreeNode root) {

        if (root==null) return Integer.MIN_VALUE;
        return Math.max(root.data,Math.max(getMax(root.left),getMax(root.right)));
    }
//******************************************************************************************
    private static int getSize(TreeNode root) {
        if(root==null) return  0;

        return 1+getSize(root.left)+getSize(root.right);
    }
//*******************************************************************************************
    private static void sizeBT(TreeNode root) {
        if(root==null) return;
          count++;
          sizeBT(root.left);
          sizeBT(root.right);
    }
}
