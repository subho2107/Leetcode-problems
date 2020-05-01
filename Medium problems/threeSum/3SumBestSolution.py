"""
15. 3Sum
Medium
Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

The solution set must not contain duplicate triplets.

Example:

Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],
  [-1, -1, 2]
]
Accepted
783,551
Submissions
3,046,975
"""
from typing import List


class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        solution = []
        for i in range(len(nums) - 2):
            if (i == 0) or (i > 0 and nums[i] != nums[i-1]):
                low = i+1
                high = len(nums) - 1
                while low < high:
                    total = nums[i] + nums[low] + nums[high]
                    if total == 0:
                        triplet = [nums[i], nums[low], nums[high]]
                        solution.append(triplet)
                        while low < high and nums[low] == nums[low + 1]:
                            low += 1
                        while low < high and nums[high] == nums[high - 1]:
                            high -= 1
                        low += 1
                        high -= 1
                    elif total < 0:
                        low += 1
                    else:
                        high -= 1
        return solution

obj  = Solution()
arr = list(map(int, input().rstrip().split()))
arr = obj.threeSum(arr)
print(arr)
