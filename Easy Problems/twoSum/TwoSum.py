"""
this approach clashes when duplicate values are there

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
    def getPos(self, arr, toFind):
        start = 0
        end = len(arr) - 1
        while start <= end:
            mid = (start + end) // 2
            if arr[mid] == toFind:
                return arr[mid]
            elif toFind < arr[mid]:
                end = mid - 1
            else:
                start = mid + 1
        return -1

    def twoSum(self, nums: List[int], target: int) -> List[int]:
        dupArr = sorted(nums)
        toFind = 0
        pos = 0
        for i in range(len(nums)):
            toFind = target - dupArr[i]
            pos = nums.index(self.getPos(dupArr, toFind))
            if pos == -1:
                continue
            else:
                toFind = nums.index(dupArr[i])
                break
        return [toFind, pos]


obj  = Solution()
arr = list(map(int, input().rstrip().split()))
toFind = int(input())
arr = obj.twoSum(arr, toFind)
print(arr)