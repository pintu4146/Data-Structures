# importing root fro the file where we have created tree
from tree_creation import root


# def in_order_travalsal(root, travalsal_list):
#     if root is None:
#         return travalsal_list
#     in_order_travalsal(root.left, travalsal_list)
#     travalsal_list.append(root.val)
#     in_order_travalsal(root.right, travalsal_list)
#     return travalsal_list
#
#
# print(in_order_travalsal(root, []))


# pythonic way for inorder travalsal

def pythonic_way_inorder(root):
    if root is None:
        return []
    return pythonic_way_inorder(root.left) + [root.val]  + pythonic_way_inorder(root.right)


print(pythonic_way_inorder(root))
