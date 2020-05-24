import heapq
# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def kthSmallest(self, root: TreeNode, k: int) -> int:
        def traverse(node, arr):
            if node is None:
                return
            arr.append(node.val)
            traverse(node.left, arr)
            traverse(node.right, arr)
        arr = []
        traverse(root, arr)
        heapq.heapify(arr)
        while k > 1:
            heapq.heappop(arr)
            k -= 1
        return heapq.heappop(arr)