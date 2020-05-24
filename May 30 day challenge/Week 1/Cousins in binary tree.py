# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:

    def isCousins(self, root: TreeNode, x: int, y: int) -> bool:
        self.parentOfX, self.parentOfY = 0, 0
        self.levelOfX, self.levelOfY = 0, 0
        if (x // 2) != (y // 2):
            return False
        else:
            def inorderTraversal(node, height):

                if not node:
                    return None
                a = node.val
                if (node.left and node.left.val == x) or (node.right and node.right.val == x):
                    self.parentOfX = node.val
                elif (node.left and node.left.val == y) or (node.right and node.right.val == y):
                    self.parentOfY = node.val
                inorderTraversal(node.left, height+1)
                a = node.val
                if (node.left and node.left.val == x) or (node.right and node.right.val == x):
                    self.parentOfX = node.val
                    self.levelOfX = height
                if (node.left and node.left.val == y) or (node.right and node.right.val == y):
                    self.parentOfY = node.val
                    self.levelOfY = height
                inorderTraversal(node.right, height+1)

            inorderTraversal(root, 0)
            print(self.parentOfX, self.parentOfY)
            if self.parentOfX != self.parentOfY and self.levelOfY == self.levelOfX:
                return True
            else:
                return False


obj = Solution()
node = TreeNode(1)
node.left = TreeNode(2)
node.left.right = TreeNode(4)
node.right = TreeNode(3)

print(obj.isCousins(node, 2, 3))