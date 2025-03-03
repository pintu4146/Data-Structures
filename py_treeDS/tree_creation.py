"""
        10
       /  \
      5    15
     / \   / \
    3   7 12 18

"""


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right


root = TreeNode(10, TreeNode(5, TreeNode(3), TreeNode(7)), TreeNode(15, TreeNode(12), TreeNode(18))

                )

