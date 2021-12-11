public class diameterOfBT {
    public static  void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right = new TreeNode(30);
        root.right.right = new TreeNode(60);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        root.left.right.left = new TreeNode(70);
        root.left.right.right = new TreeNode(80);
    }
}
