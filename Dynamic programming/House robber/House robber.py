from typing import List


class Solution:
    def rob(self, nums: List[int]) -> int:
        if nums == []:
            return 0
        for pos in range(2, len(nums)):
            maxMoney = nums[pos - 2]
            if pos - 3 >= 0 and nums[pos - 3] > nums[pos - 2]:
                maxMoney = nums[pos - 3]
            nums[pos] = nums[pos] + maxMoney

            # print(nums)
        return max(nums)


obj = Solution()
print("Enter val of list")
arr = list(map(int, input().rstrip().split()))
num = obj.rob(arr)
print(num)