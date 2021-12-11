/*Children Sum Property is a property in which the sum of values of the
left child and right child should be equal to the value of their node if both children are present.
Else if only one child is present then the value of the child should be equal to its node value.
In this , we discuss a recursive function that takes the root node as a parameter and returns
 TRUE if the Tree follows C.S.P. and FALSE if the Tree does not follow C.S.P.*/


import java.util.Scanner;

public class CSP {
    public static  void  main(String[] args)
    {
        System.out.println("enter and choose from 1 to 5 tree");
        Scanner sc=new Scanner(System.in);
        int choice=sc.nextInt();
        switch (choice)
        {
            case  1: {
                        TreeNode root=new TreeNode(20);
                       root.left=new TreeNode(8);
                       root.right=new TreeNode(12);
                       root.left.left=new TreeNode(30);
                       root.left.right=new TreeNode(5);
                       boolean res= isCsp(root);
                    System.out.println(res  );


                       break;}
            case 2:{
                     TreeNode root=null;
                boolean res= isCsp(root);
                System.out.println(res  );
                break;
            }
            case 3:{
                TreeNode root=new TreeNode(10);
                  root.left=new TreeNode(10);
                boolean res= isCsp(root);
                System.out.println(res  );
            }
        }
    }


    private static boolean isCsp(TreeNode root) {
        if(root==null) return  true;
        if(root.left==null && root.right==null) return  true;
        int sum=0;
        if(root.left != null) {
            sum=sum+root.left.data;
        }
        if (root.right !=null) {
            sum+=root.right.data;
        }
        return (root.data==sum && isCsp(root.left) && isCsp( root.right) );

    }
}
