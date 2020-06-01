from typing import List


class Solution:
    def singleNumber(self, nums: List[int]) -> int:
        nums.sort()
        numNoRep = 0
        check = False
        for pos in range(0, len(nums) - 1, 2):
            if nums[pos] != nums[pos+1]:
                numNoRep = nums[pos]
                check = True
                break
        if not check:
            return nums[len(nums)-1]
        return numNoRep

obj = Solution()
arr = list(map(int, input().rstrip().split()))
num = obj.singleNumber(arr)
print(num)