class Solution:
    def climbStairs(self, n:int)->int:
        if n < 1:
            return 1
        preCompDict = {1:1, 2:2}
        for num in range(3, n+1):
            preCompDict[num] = preCompDict[num-1] + preCompDict[num-2]
        return preCompDict[n]

obj = Solution()
print("Enter val of n")
n = int(input())
num = obj.climbStairs(n)
print(num)