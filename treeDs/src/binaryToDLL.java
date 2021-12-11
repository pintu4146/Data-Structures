/*Inorder conversion of Binary Tree to Doubly Linked List.
A function that takes root of a Binary Tree and converts it into a Doubly linked list.
Hint:- we need to do the inorder traversal of the Tree and while doing inorder traversal
we can simply maintain a previous pointer or reference of the previously traversed node.
 And change right child of the previous node to current node and left child of current node as previous.*/

public class binaryToDLL {
    public static  void  main(String[] args)
    {
        TreeNode root=new TreeNode(20);
        root.left=new TreeNode(8);
        root.right=new TreeNode(12);
        root.left.left=new TreeNode(30);
        root.left.right=new TreeNode(5);
    }
}
