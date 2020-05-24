from typing import List
import bisect

class Solution:
    def longestSubarray(self, nums: List[int], limit: int) -> int:
        if not nums:
            return 0
        if len(nums) == 1:
            return 1
        currMin = nums[0]
        currMax = nums[0]
        maxLen = 1
        l=0
        r=1
        while r < len(arr) and l <= r:
            currMax = max(currMax, nums[r])
            currMin = min(currMin, nums[r])
            if currMax-currMin <= limit:
                maxLen = max(maxLen, r-l+1)
            else:
                if nums[l] == currMax:
                    currMax = max(nums[l+1:r+1])
                if nums[l] == currMin:
                    currMin = min(nums[l+1:r+1])
                l+=1
            r+=1
        return maxLen


obj = Solution()
arr = list(map(int , input().rstrip().split()))
limit = int(input())
print(obj.longestSubarray(arr, limit))