import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
      TreeNode(int val)
      {
          data=val;
          left=null;
          right=null;
      }
}



public class treeCreation {
    public static  void main(String[] args)
    {
         TreeNode root=new TreeNode(10);
         root.left=new TreeNode(20);
         root.right=new TreeNode(30);
         root.right.right=new TreeNode(60);
         root.left.left=new TreeNode(40);
         root.left.right=new TreeNode(50);
         root.left.right.left=new TreeNode(70);
         root.left.right.right=new TreeNode(80);
         //Breadth First Traversal (also called level  order travarsal )
           printLevels(root);



//         //Depth first Traversal
        System.out.print("Inorder: ");
         inOrderTraversal(root);  //////
         System.out.println();
        System.out.print("Preorder: ");
         preorderTraversal(root);
        System.out.println();
        System.out.print("Postorder: ");
        postorderTravesal(root);
////////Finding Height of the tree
      int height=  treeHeight(root);
      System.out.println("\nHeight of tree:  "+height);
//      Print all  nodes At distance K from Root node
              int k=2;
        System.out.println("Distance "+ k+" has node ");
            printKdistanceNode(root,k);


    }

    private static void printLevels(TreeNode root) {
        if(root==null) return;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while (! q.isEmpty())
        {
            TreeNode curr=q.poll();
            System.out.print(curr.data+" ");
            if(curr.left !=null)
                    q.add(curr.left);
            if(curr.right !=null)
            {
                q.add(curr.right);
            }

//System.out.println();
        }






    }

    private static void printKdistanceNode(TreeNode root, int k) {
        if(root == null)
        { return; }
        if(k==0) {
            System.out.print(root.data + " ");
        } else {
            printKdistanceNode(root.left,k-1);
            printKdistanceNode(root.right,k-1);
        }
    }

    public static int treeHeight(TreeNode root) {
          if(root==null)
              return 0;
          return Math.max(treeHeight(root.left),treeHeight(root.right))+1;
    }

    private static void postorderTravesal(TreeNode root) {
        if(root==null) return;
        postorderTravesal(root.left);
        postorderTravesal(root.right);
        System.out.print(root.data+" ");
    }

    private static void preorderTraversal(TreeNode root) {
        if(root==null) return;
        System.out.print(root.data+" ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    private static void inOrderTraversal(TreeNode root) {
        if(root==null) return;
        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);
        


    }
}
