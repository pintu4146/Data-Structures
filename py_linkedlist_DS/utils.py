from creation import Node

# ANSI color codes for highlighting the changes
HIGHLIGHT_ADD = "\033[92m"  # Green for insertion
HIGHLIGHT_REMOVE = "\033[91m"  # Red for deletion
RESET = "\033[0m"  # Reset color to default


def disply_ll(head: Node, message: str):
    print(message)
    while head:
        print(head.data, end='->')
        head = head.next
    print('None')


def count_nodes(original_head):
    node_count_count = {}
    while original_head:
        node_count_count[original_head.data] = node_count_count.get(original_head.data, 0) + 1
        original_head = original_head.next
    return node_count_count


def disply_ll_highlight(original_head: Node, modified_head: Node, message: str):
    """
    Displays the linked list with any changes highlighted.
    - Green for insertions
    - Red for deletions
    """
    print(message)

    # Count occurrences of each node value before and after modifications
    original_counts = count_nodes(original_head)
    modified_counts = count_nodes(modified_head)

    temp = modified_head
    while temp:
        if modified_counts[temp.data] > original_counts.get(temp.data, 0):  # New occurrence detected
            print(f"{HIGHLIGHT_ADD}{temp.data}{RESET}", end="->")
            # modified_counts[temp.data] -= 1  # Reduce count to mark it as handled
        else:
            print(temp.data, end="->")
        temp = temp.next

    # Highlight deleted nodes (when counts are reduced)
    for value, count in original_counts.items():
        if count > modified_counts.get(value, 0):  # Deletion detected
            for _ in range(count - modified_counts.get(value, 0)):
                print(f"{HIGHLIGHT_REMOVE}{value}{RESET}", end="(deleted)->")

    print("None")


def custom_len(head: Node, count=0) -> int:
    while head:
        count += 1
        head = head.next
    return count