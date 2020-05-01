from typing import List
class Solution:
    def minSubsequence(self, nums: List[int]) -> List[int]:
        nums.sort(reverse = True)
        sumNum = sum(nums)
        maxArr = []
        sumSmall = 0
        for pos in range(0, len(nums)):
            sumSmall += nums[pos]
            sumRest =  sumNum - sumSmall
            if sumSmall > sumRest:
                maxArr = nums[0:pos+1]
                break
        if maxArr == []:
            return nums
        else:
            return maxArr
    
obj = Solution()
n = list(map(int, input().rstrip().split()))
print(obj.minSubsequence(n))

