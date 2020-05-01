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
        solution = set()
        pos =  {}
        neg = {}
        zeroes = 0
        nums.sort()
        """
        The following code creates a hash map for storing the freq of different numbers
        positive nums separately negatives separately and having a variable to store the
        number of zeroes.
        """
        for num in nums:
            if num < 0:
                neg.setdefault(num, 0)
                neg[num] += 1
            elif num > 0:
                pos.setdefault(num, 0)
                pos[num] += 1
            else:
                zeroes += 1
        """
        The following code segment will iterate through the nums list as an set
        and for each number faced (let's say i) it will search for two numbers j
        and k such that k = -(i+j)
        """
        for firstNum in {i for i in nums}:
            if firstNum < 0:
                for secondNum in pos:
                    thirdNum = -firstNum - secondNum
                    if thirdNum in pos:
                        if secondNum == thirdNum and pos[secondNum] < 2:#if second and third number are present separately
                            continue
                        else:
                            tempTuple = tuple(sorted((firstNum,secondNum,thirdNum)))
                            solution.add(tempTuple)
                    elif thirdNum == 0 and zeroes >= 1:
                        tempTuple = tuple(sorted((firstNum, secondNum, 0)))
                        solution.add(tempTuple)
            elif firstNum > 0:
                for secondNum in neg:
                    thirdNum = -firstNum - secondNum
                    if thirdNum in neg:
                        if secondNum == thirdNum and neg[secondNum] < 2:#if second and third number are present separately
                            continue
                        else:
                            tempTuple = tuple(sorted((firstNum,secondNum,thirdNum)))
                            solution.add(tempTuple)
                    elif thirdNum == 0 and zeroes >= 1:
                        tempTuple = tuple(sorted((firstNum, secondNum, 0)))
                        solution.add(tempTuple)
            else:
                if zeroes >= 3:
                    solution.add((0, 0, 0))
        return [list(triplet) for triplet in solution]


obj  = Solution()
arr = list(map(int, input().rstrip().split()))
arr = obj.threeSum(arr)
print(arr)





