# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def searchBST(self, root: TreeNode, val: int):
        if not root:
            return
        if root.val == val:
            return root
        if root.val > val:
            isInLeft = self.searchBST(root.left, val)
            if isInLeft:
                return isInLeft
        else:
            isInRight = self.searchBST(root.right, val)
            if isInRight:
                return isInRight
        return None
