from typing import List
import random
class Solution:
    def canJump(self, nums: List[int]) -> bool:
        nearestTrue = len(nums)-1
        for pos in range(len(nums)-1, -1, -1):
            if pos + nums[pos] >= nearestTrue:
                nearestTrue = pos
        return nearestTrue == 0
