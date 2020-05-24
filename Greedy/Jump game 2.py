from typing import List
class Solution:
    def jump(self, nums: List[int]) -> int:
        if len(nums) == 1:
            return 0
        coverage, lastJumpIndex = 0, 0
        noOfJumps = 0
        for pos in range(0, len(nums)):
            coverage = max(coverage, pos+nums[pos])
            if pos == lastJumpIndex:
                lastJumpIndex = coverage
                noOfJumps+=1
                if coverage >= len(nums)-1:
                    return noOfJumps
        return noOfJumps