class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

def middleNode( head: ListNode) -> ListNode:
    arr = []
    while head.next != None:
        arr.append(head)
    return arr[len(arr)//2]
