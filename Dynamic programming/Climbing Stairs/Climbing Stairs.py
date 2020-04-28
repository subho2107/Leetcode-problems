class Solution:
    def climbStairs(self, n:int)->int:
        preCompDict = {}
        return self.helperMethod(n,preCompDict)
    def helperMethod(self, n:int, preCompDict)->int:
        if n < 1:
            return 0
        elif n == 1:
            return 1
        elif n == 2:
            return 2
        else:
            if n in preCompDict:
                return preCompDict[n]
            preCompDict[n] =  self.helperMethod(n-1, preCompDict) + self.helperMethod(n-2, preCompDict)
            return preCompDict[n]

obj = Solution()
print("Enter val of n")
n = int(input())
num = obj.climbStairs(n)
print(num)