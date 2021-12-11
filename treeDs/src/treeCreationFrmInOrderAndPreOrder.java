public class treeCreationFrmInOrderAndPreOrder {
    public  static void main(String[] args)
    {
        int in[]={20,10,40,30,50};
        int pre[]={10,20,30,40,50};
        TreeNode root=ConstructTree(in,pre,0,4);
        preorderTraversal(root);
    }

    private static void preorderTraversal(TreeNode root) {
        if(root == null) return;
        System.out.print(root.data+ ",");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }


    static  int preIndex=0;
    private static TreeNode ConstructTree(int[] in, int[] pre, int is, int ie) {
        if(is>ie) return null ;
          TreeNode root=new TreeNode(pre[preIndex++]);

          int inIndex=is;
          for(int i=0;i<=ie;i++)
          {
              if(in[i]==root.data)
              {
                  inIndex=i;
                  break;
              }
          }
          root.left=ConstructTree(in,pre,is,inIndex-1);
          root.right=ConstructTree(in,pre,inIndex+1,ie);
          return  root;
    }
}