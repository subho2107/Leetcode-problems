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
solution = []
dup = []
class Solution:
    def twoSum(self, nums: List[int], target: int, num: int, i: int) -> List[List[int]]:
        global solution
        global dup
        hashMap = {}
        arr = []
        for pos in range(len(nums)):
            complement = target - nums[pos]
            if complement in hashMap:
                tempArr = sorted([num, dup[hashMap[complement]+i+1], dup[pos+i+1]])
                if (tempArr not in solution) and (tempArr not in arr):
                    arr.append(tempArr)
                    #print(tempArr, end=" ")
            hashMap[nums[pos]] = pos
        #zprint(" ")
        if arr == []:
            return [[-1, -1, -1]]
        else:
            return arr

    def threeSum(self, nums: List[int]) -> List[List[int]]:
        global solution
        global dup
        dup = nums

        for i in range(0, len(nums)):
            num = nums[i]
            target = 0 - num
            arr = self.twoSum(nums[i+1:], target, num, i)
            #print("in three sum",i, arr,target, nums[i+1:])
            if arr != [[-1,-1,-1]] :

                #arr[1], arr[2] = nums[arr[1]+i+1], nums[arr[2]+i+1]
                #print(num, arr)
                #arr = [num] + arr
                solution += arr
                #print("here",solution,arr)
        return solution

obj  = Solution()
arr = list(map(int, input().rstrip().split()))
arr = obj.threeSum(arr)
print(arr)

