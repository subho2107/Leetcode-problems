from typing import List
import random
class Solution:
    def canJump(self, nums: List[int]) -> int:
        nearestTrue = len(nums)-1
        cnt = 0
        for pos in range(len(nums)-1, -1, -1):
            if pos + nums[pos] >= nearestTrue:
                nearestTrue = pos
                cnt += 1
        return cnt
