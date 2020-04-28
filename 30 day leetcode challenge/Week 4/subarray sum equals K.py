
from typing import List
class Solution:
    def subarraySum(self, nums: List[int], k: int) -> int:
        if len(nums) == 1 and nums[0] == k:
            return 1
        hashSum = {}
        currSum = 0
        cnt = 0
        checkAllZero = True
        for pos in range(len(nums)):
            num = nums[pos]
            currSum += num
            if num != 0:
                checkAllZero = False
            if currSum-k in hashSum:
                cnt += hashSum[currSum-k]
            elif num != currSum:
                if k in hashSum:
                    cnt += hashSum[k]
                else:
                    cnt += 1
            if currSum in hashSum:
                hashSum[currSum] += 1
            else:
                hashSum[currSum] = 1
            # print(cnt)
        if checkAllZero:
            cnt += len(nums)
        return cnt

obj = Solution()
arr = list(map(int, input().rstrip().split()))
k = int(input())
print(obj.subarraySum(arr, k))