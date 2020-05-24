from typing import List
class Solution:
    def singleNonDuplicate(self, nums: List[int]) -> int:
        hashFreq = {}
        for num in nums:
            if num not in hashFreq:
                hashFreq[num] = 1
            else:
                hashFreq[num] += 1
        for num in hashFreq:
            if hashFreq[num] == 1:
                return num
        return -1