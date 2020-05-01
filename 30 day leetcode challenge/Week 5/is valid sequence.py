from typing import List
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def isValidSequence(self, root: TreeNode, arr: List[int]) -> bool:
        if not root:
            return len(arr)==0
        def helper(root, arr, n, index):
            if not root or index == n:
                return n==0
            if not root.left and not root.right:
                if root.val == arr[index] and index == n-1:
                    return True
                return False

            return index < n and root.val == arr[index] and (helper(root.left, arr, n,index+1) or \
                                                             helper(root.right, arr, n, index+1))
        return helper(root, arr, len(arr), 0)
root = TreeNode(0)
root.left =TreeNode(1)
root.left.right = TreeNode(1)
root.left.right.left = TreeNode(0)
root.left.right.right = TreeNode(0)
root.left.left = TreeNode(0)
root.left.left.right = TreeNode(1)
root.right = TreeNode(0)
root.right.left = TreeNode(0)
print(Solution().isValidSequence(root, [0, 1, 0, 1]))