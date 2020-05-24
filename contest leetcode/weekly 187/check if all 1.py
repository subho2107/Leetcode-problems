from typing import List
class Solution:
    def kLengthApart(self, nums: List[int], k: int) -> bool:
        arrPos = []
        for pos in range(0, len(nums)):
            if nums[pos] == 1:
                arrPos.append(pos)
        for pos in range(0, len(arrPos)-1):
            if arrPos[pos+1]-arrPos[pos]-1>k:
                return False
        return True
