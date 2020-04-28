"""
this is using only one iteration
using hash map

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
        hashMap = {}
        for pos in range(len(nums)):
            complement = target - nums[pos]
            if complement in hashMap:
                return [hashMap[complement], pos]
            hashMap[nums[pos]] = pos

        raise Exception("Two sum does not exist")


obj  = Solution()
arr = list(map(int, input().rstrip().split()))
toFind = int(input())
arr = obj.twoSum(arr, toFind)
print(arr)