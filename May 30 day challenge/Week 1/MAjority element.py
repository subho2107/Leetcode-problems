from typing import List
class Solution:
    def majorityElement(self, nums: List[int]) -> int:
        hashFreq = {}
        length = len(nums)//2
        for number in hashFreq:
            if number not in hashFreq:
                hashFreq[number] = 1
            else:
                hashFreq[number] += 1
                if hashFreq[number] > length:
                    return number
        return nums[0]