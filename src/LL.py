class Node:
    def __init__(self,data):
        self.data = data
        self.next = None
class LinkedList:
    def __init__(self):
        self.head = None
    def printList(self):
        temp = self.head
        while(temp):
            print("%d "%(temp.data))
            temp = temp.next
if __name__=='__main__':
    Llist = LinkedList()
    Llist.head = Node(1)
    second = Node(2)
    third = Node(3)
    Llist.head.next = second;
    second.next = third;
    Llist.printList()