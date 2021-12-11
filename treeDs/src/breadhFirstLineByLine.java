import java.util.LinkedList;
import java.util.Queue;

public class breadhFirstLineByLine {
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
        System.out.println("Method one Printing");
          printLevelLineByLine(root);
          System.out.println();
          System.out.println("Method two Printing");
        METHOD2printLevelLineByLine(root);
    }

    private static void METHOD2printLevelLineByLine(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while ( !q.isEmpty())
        {
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                System.out.print(curr.data+" ");
                if(curr.left !=null) q.add(curr.left);
                if (curr.right !=null) q.add(curr.right);
            }
            System.out.println();
        }
    }


    private static void printLevelLineByLine(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        q.add(null);
        while (q.size()>1)
        {
            TreeNode curr=q.poll();
            if(curr == null)
            {
                System.out.println();
                q.add(null);
                continue;
            }
            System.out.print(curr.data+" ");
            if (curr.left !=null)
                    q.add(curr.left);
            if (curr.right != null)
                  q.add(curr.right);
        }
    }
}
