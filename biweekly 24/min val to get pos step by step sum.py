from typing import List


class Solution:
    def checkPos(self, nums):
        checkAllPos = True
        for num in nums:
            if num < 0:
                checkAllPos = False
                break
        return checkAllPos
    def minStartValue(self, nums: List[int]) -> int:
        checkAllPos = self.checkPos(nums)
        if checkAllPos:
            return 1
        else:
            sumOfNums = 0
            for pos in range(len(nums)):
                num = nums[pos]
                sumOfNums += num
                nums[pos] = sumOfNums
            if self.checkPos(nums):
                return 1
            minNum = min(nums)
            return abs(minNum) + 1


#[2,3,5,-5,-1]