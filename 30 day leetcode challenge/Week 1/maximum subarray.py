from typing import List


def maxSubArray(nums: List[int]) -> int:
    for pos in range(1, len(nums)):
        largestSumTillPresent = max(nums[pos], nums[pos]+nums[pos-1])
        nums[pos] = largestSumTillPresent
    return max(nums)
print(maxSubArray(list(map(int, input().rstrip().split()))))