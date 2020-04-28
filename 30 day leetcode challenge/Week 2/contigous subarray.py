from typing import List
class Solution:
    def findMaxLength(self, nums: List[int]) -> int:
        sumTillPres = 0
        length = len(nums)
        for pos in range(length):
            num = nums[pos]
            if num == 0:
                nums[pos] = -1
        maxLen = 0
        hashSumPos = {}
        for pos in range(length):
            sumTillPres += nums[pos]
            if sumTillPres == 0:
                maxLen = pos+1


            if sumTillPres in hashSumPos:
                if maxLen < pos - hashSumPos[sumTillPres] :
                    maxLen = pos - hashSumPos[sumTillPres]
            else:
                hashSumPos[sumTillPres] = pos

        return maxLen

arr = list(map(int, input().rstrip().split()))
maxLen = Solution().findMaxLength(arr)
print(maxLen)
