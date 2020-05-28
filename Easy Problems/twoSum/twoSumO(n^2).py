"""
this is brute force approach

1. Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
"""
from typing import List


class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        arr = []
        for i in range(0, len(nums)):
            num = nums[i]
            for j in range(i, len(nums)):
                if num + nums[j] == target:
                    arr = [i, j]
                    break

        return arr


obj  = Solution()
arr = list(map(int, input().rstrip().split()))
toFind = int(input())
arr = obj.twoSum(arr, toFind)
print(arr)