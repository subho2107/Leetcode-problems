from typing import List
class Solution:
    def maxSubarraySumCircular(self, A: List[int]) -> int:
        sumArr = sum(A)
        maxSum = float("-inf")
        minSum = float("inf")
        currSum = float("-inf")
        for num in A:
            currSum = num + max(currSum, 0)
            maxSum = max(maxSum, currSum)
        currSum = float("inf")
        for num in A:
            currSum = num + min(currSum, 0)
            minSum = min(minSum, currSum)
        if sumArr == minSum:
            return maxSum
        return max(sumArr-minSum, maxSum)
