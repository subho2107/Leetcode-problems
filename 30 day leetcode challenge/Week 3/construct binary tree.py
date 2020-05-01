# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
from typing import List
class Solution:
    def bstFromPreorder(self, preorder: List[int]) -> TreeNode:
        if len(preorder) == 1:
            return TreeNode(preorder[0])
        leftChilds = []
        rightChilds = []
        rootNode = TreeNode(preorder[0])
        temp = 999999
        for pos in range(1, len(preorder)):
            num = preorder[pos]
            if num < preorder[0]:
                leftChilds.append(num)
            else:
                temp = pos
                break
        if temp >= 0 and temp < len(preorder):
            rightChilds = preorder[temp:]
        if len(leftChilds):
            rootNode.left = self.bstFromPreorder(leftChilds)
        if len(rightChilds):
            rootNode.right = self.bstFromPreorder(rightChilds)
        return rootNode
