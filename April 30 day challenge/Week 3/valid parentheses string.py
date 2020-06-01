import random
def testGenerator():
    for i in range(10):
        length = random.randint(1,5)
        string = ""
        charArr = ['(', ')', '*']
        for pos in range(length):
            index = random.randint(0, 2)
            string += charArr[index]
        print(Solution().checkValidString(string))


class Solution:
    def checkValidString(self, s: str) -> bool:
        leftbalance = 0
        for ch in s:
            if ch == '(' or ch == '*':
                leftbalance += 1
            else:
                leftbalance -= 1
            if leftbalance < 0:
                return False
        if leftbalance == 0:
            return True

        rightbalance = 0
        for ch in reversed(s):
            if ch == ')' or ch == '*':
                rightbalance += 1
            else:
                rightbalance -= 1
            if rightbalance < 0:
                return False

        return True

obj = Solution()
