import sys


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    maxSum = -9999999
    def maxPathSum(self, root: TreeNode) -> int:
        def getMaxSum(root):
            if root is None:
                return 0
            left = max(0, getMaxSum(root.left))
            right = max(0, getMaxSum(root.right))
            self.maxSum = max(self.maxSum, left+right+root.val)
            return max(left, right) + root.val
        getMaxSum(root)
        return self.maxSum

root = TreeNode(1)
root.left = TreeNode(2)
root.right = TreeNode(3)
obj = Solution()
print(obj.maxPathSum(root))