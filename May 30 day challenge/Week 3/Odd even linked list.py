# Definition for singly-linked list.
class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def createLinkedList(self,nodeToForm,nodeToCopy):
        while nodeToCopy is not None:
            nodeToForm.val = nodeToCopy.val
            if nodeToCopy.next is not None and nodeToCopy.next.next is not None:
                nodeToForm.next = ListNode()
            else:
                break
            nodeToForm = nodeToForm.next
            nodeToCopy = nodeToCopy.next.next
        return nodeToForm
    def oddEvenList(self, head: ListNode) -> ListNode:
        if not head:
            return head
        newHead = ListNode()
        dup = head
        dup2 = newHead
        newHead = self.createLinkedList(newHead, head)
        if dup.next is None:
            newHead.next = None
            return dup2
        newHead.next = ListNode()
        newHead = self.createLinkedList(newHead.next, dup.next)
        newHead.next = None
        return dup2
head = ListNode()
dup = head
# for num in range(1,6):
#     head.val = num
#     if num != 5:
#         head.next = ListNode()
#     head = head.next
obj = Solution().oddEvenList(dup)
while obj is not None:
    print(obj.val, end=" ")
    obj = obj.next
