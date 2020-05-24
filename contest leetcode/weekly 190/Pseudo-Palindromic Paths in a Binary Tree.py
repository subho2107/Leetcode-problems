import collections
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right
class Solution:
    def pseudoPalindromicPaths (self, root: TreeNode) -> int:
        def palinChecker(text):
            hashMap = collections.Counter(text)
            check = False
            checkPalin = True
            for num in hashMap:
                if hashMap[num]&1 and not check:
                    check = True
                elif not hashMap[num] & 1:
                    continue
                else:
                    checkPalin = False
                    break
            return checkPalin

        def getPseudoPalinCnt(node, string):
            if not node:
                return
            string += str(node.val)
            if not node.left and not node.right:
                if palinChecker(string):
                    return 1
                else:
                    return 0
            leftChildCnt = getPseudoPalinCnt(node.left, string)
            rightChildCnt = getPseudoPalinCnt(node.right, string)
            return leftChildCnt + rightChildCnt
        return getPseudoPalinCnt(root, "")
