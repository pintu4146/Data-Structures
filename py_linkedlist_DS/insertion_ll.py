from creation import node_list, node_dict, Node
from utils import disply_ll, disply_ll_highlight, custom_len


def insert_at_beginning(linkedlist: list, data: int) -> Node:
    """
    Inserts a new node at the beginning of the linked list.
    Updates the linked list in-place.
    """
    # lets created Node instance first in order to insert
    new_node = Node(data)
    # getting head of the existing
    head = linkedlist[0]
    new_node.next = head
    return new_node


def insertion(original_ll_head: Node, index: int, data: int) -> Node:
    """
    :param index: index at which
    :param data: new data to be inserted
    :return: head of modified linked list
    """
    count = custom_len(original_ll_head)
    new_node = Node(data)
    if index > count:
        raise IndexError('Index out of bound error')
    if index == 0:
        new_node.next = original_ll_head
        return new_node
    if index < 0:
        raise ValueError("index cant be negetive")

    curr_head = original_ll_head
    prev = None
    while index > 0:
        prev = curr_head
        curr_head = curr_head.next
        index -= 1
    temp = curr_head.next
    prev.next = new_node
    new_node.next = temp
    return original_ll_head


if __name__ == '__main__':
    ll = insert_at_beginning(node_list, 1)
    # disply_ll(insertion(node_list[0], 3, 100), 'inserting at beginning and printing node')
    # disply_ll_highlight(node_list[0], ll, 'inserting at beginning and printing node')

    # insertion at given index

    disply_ll_highlight(node_list[0], insertion(node_list[0], 1, 100), 'inserting at any position and printing node')
#