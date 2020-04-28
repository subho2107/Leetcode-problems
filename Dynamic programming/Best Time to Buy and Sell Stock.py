from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        dupArr = prices[:]
        for pos in range(1, len(prices)):
            if dupArr[pos] > dupArr[pos-1]:
                dupArr[pos] = dupArr[pos-1]
        maxDiff = 0
        for pos in range(1, len(prices)):
            diff = prices[pos] - dupArr[pos]
            if diff > maxDiff:
                maxDiff = diff
        return maxDiff

obj = Solution()
print("Enter val of list")
arr = list(map(int, input().rstrip().split()))
num = obj.maxProfit(arr)
print(num)