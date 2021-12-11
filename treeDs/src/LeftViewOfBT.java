/*To Print Left View of Binary Tree we need to print the leftmost node at every level of the Binary Tree.

In this  we discuss two methods to print left view of a given Binary Tree.In Method-1 we use Recursive
method whereas in Method-2 we use the Iterative method approach by using queue datastructure.*/

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfBT {
    public  static  void main(String[] args)
    {
        TreeNode root=new TreeNode(10);
        root.left=new TreeNode(20);
        root.right=new TreeNode(30);
        root.right.right=new TreeNode(60);
        root.left.left=new TreeNode(40);
        root.left.right=new TreeNode(50);
        root.left.right.left=new TreeNode(70);
        root.left.right.right=new TreeNode(80);
        System.out.println("\n\nRecurssive  solution");
          leftView(root);
          System.out.println("Iterative solution");
          leftViewIterative(root);

    }

    private static void leftViewIterative(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (q.isEmpty()==false)
        {
            int Qsize=q.size();
            for (int i=0;i<Qsize;i++)
            {
                TreeNode curr=q.poll();
                if(i==0)
                {
                    System.out.println(curr.data);
                }
                if(curr.left != null) q.add(curr.left);
                if (curr.right !=null) q.add(curr.right);
            }
        }
    }

    private static void leftView(TreeNode root) {
        helper(root,1);


    }
private  static int maxLevel=0;
    private static void helper(TreeNode root, int Level) {
        if (root == null) return;
        if(maxLevel<Level)
        {
            System.out.println(root.data);
            maxLevel=Level;
        }
        helper(root.left,Level+1);
        helper(root.right, Level+1);

    }


}
