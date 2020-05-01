class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def init(self):
        self.maxDiameter = 0
        self.leftMostNodes = {}
    def diameterOfBinaryTree(self, root: TreeNode) -> int:
        self.init()
        def getDiameter(root, position, height):
            if root is None:
                return
            if height not in self.leftMostNodes:
                self.leftMostNodes[height] = position
            # a = self.leftMostNodes
            self.maxDiameter = max(self.maxDiameter, position - self.leftMostNodes[height] + 1)
            print(self.maxDiameter, self.leftMostNodes)
            getDiameter(root.left, position*2, height+1)
            getDiameter(root.right, (position*2) + 1, height+1)
        getDiameter(root, 0, 0)
        return self.maxDiameter
root = TreeNode(1)
root.right = TreeNode(2)

print(Solution().diameterOfBinaryTree(root))
root = TreeNode(1)
root.right = TreeNode(2)
root.left = TreeNode(3)
print(Solution().diameterOfBinaryTree(root))