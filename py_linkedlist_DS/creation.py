
class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


# creating node with data and next pointer
node1 = Node(10)
node2 = Node(20)
node3 = Node(30)
node4 = Node(40)


# let's link the nodes

node1.next = node2
node2.next = node3
node3.next = node4

# dynamic creation using list comprehension

node_list = [Node(data*10) for data in range(1, 5)]

# dynamic creation using dict coprehension
node_dict = {f'node_{i}': Node(i*10) for i in range(1, 6)}


# dynamic linking of node created by list comprehension
for i in range(len(node_list)-1):
    node_list[i].next = node_list[i+1]

# dynamic linking of node created by dict comprehension
for i in range(1, len(node_dict)-1):
    node_dict[f'node_{i}'].next = node_dict[f'node_{i+1}']
# printing linkedList
head = node_list[0]
print("Linkedlist traversed using list comprehension")
while head:
    print(head.data, end='->')
    head = head.next
print('None')
print("Linkedlist traversed using dict comprehension")
dict_head = node_dict['node_1']

while dict_head:
    print(dict_head.data, end='->')
    dict_head = dict_head.next
print('None')
